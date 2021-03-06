/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author jared
 */
public class MDB extends Conexion {
    PreparedStatement ps;
    Connection con;
    ResultSet rs;
    
    
    public boolean inicioSesion (String noEmpleado, String password, Usuario u, Sucursal s){
        con = getConexion();
        String sql = "SELECT * FROM usuario U JOIN sucursal S WHERE U.idSucursal = S.idSucursal AND numeroEmpleado=? AND pass=? LIMIT 1";
        try{
            ps = con.prepareCall(sql);
            ps.setInt(1, Integer.parseInt(noEmpleado));
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()){
                u.setNumeroEmpleado(rs.getInt(1));
                u.setNombre(rs.getString(2));
                u.setPass(rs.getString(3));
                u.setAdmin(rs.getBoolean(4));
                u.setIdSucursal(rs.getInt(5));
                s.setIdSucursal(rs.getInt(6));
                s.setNombre(rs.getString(7));
                return true;
            }
            return false;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    public List listadoAbierto(){
        List<Producto>datos = new ArrayList<>();
        con = getConexion();
        String sql = "SELECT * FROM producto";
        try{
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Producto p = new Producto();
                p.setIdProducto(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setMarca(rs.getString(3));
                p.setCantidad(rs.getInt(4));
                datos.add(p);
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return datos;
    }
    
    public List listadoCerrado(Usuario u, int sucursal){
        List<Producto>datos = new ArrayList<>();
        con = getConexion();
        String sql = "SELECT * FROM producto P JOIN inventario I WHERE P.idProducto = I.idProducto AND I.idSucursal=? ORDER BY P.idProducto ASC";
        try{
            ps = con.prepareCall(sql);
            if (u.isAdmin()){
                ps.setInt(1, sucursal);
            }else{
                ps.setInt(1, u.getIdSucursal());
            }
            
            rs = ps.executeQuery();
            while (rs.next()){
                Producto p = new Producto();
                p.setIdProducto(rs.getInt("idProducto"));
                p.setNombre(rs.getString("nombre"));
                p.setMarca(rs.getString("marca"));
                p.setCantidad(rs.getInt(7));
                datos.add(p);
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return datos;
    }
    
    public boolean nuevoProducto(Producto p, int sucursal){
        int cantidad = p.getCantidad();
        con = getConexion();
        String sql = "SELECT * FROM producto WHERE nombre=? AND marca=? LIMIT 1";
        try{
            ps = con.prepareCall(sql);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getMarca());
            rs = ps.executeQuery();
            if (rs.next()){
                p.setCantidad(p.getCantidad()+rs.getInt("cantidad"));
                p.setIdProducto(rs.getInt("idProducto"));
                sql = "SELECT * FROM inventario WHERE idProducto=? AND idSucursal=? LIMIT 1";
                ps = con.prepareCall(sql);
                ps.setInt(1, p.getIdProducto());
                ps.setInt(2, sucursal);
                rs = ps.executeQuery();
                if(rs.next()){
                   return false; 
                }else {
                    sql = "INSERT INTO inventario(idSucursal, idProducto, cantidad) VALUES (?,?,?)";
                    try{
                        ps = con.prepareCall(sql);
                        ps.setInt(1, sucursal);
                        ps.setInt(2, p.getIdProducto());
                        ps.setInt(3, cantidad);
                        ps.executeUpdate();
                    }catch (SQLException e){
                        JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
                        System.out.println(e);
                    }
                    sql = "UPDATE producto SET cantidad=? WHERE idProducto=?";
                    try{
                        ps = con.prepareCall(sql);
                        ps.setInt(1, p.getCantidad());
                        ps.setInt(2, p.getIdProducto());
                        ps.executeUpdate();
                    }catch (SQLException e){
                        JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
                        System.out.println(e);
                    }
                }
            }else{
                sql = "INSERT INTO producto(nombre,marca,cantidad) VALUES (?,?,?)";
                try{
                    ps = con.prepareCall(sql);
                    ps.setString(1, p.getNombre());
                    ps.setString(2, p.getMarca());
                    ps.setInt(3, cantidad);
                    ps.executeUpdate();
                }catch (SQLException e){
                    JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
                    System.out.println(e);
                }
                sql = "SELECT idProducto FROM producto WHERE nombre=? AND marca=? LIMIT 1";
                try{
                    ps = con.prepareCall(sql);
                    ps.setString(1, p.getNombre());
                    ps.setString(2, p.getMarca());
                    rs = ps.executeQuery();
                    if(rs.next()) p.setIdProducto(rs.getInt(1));
                }catch (SQLException e){
                    JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
                    System.out.println(e);
                }
                sql = "INSERT INTO inventario(idSucursal, idProducto, cantidad) VALUES (?,?,?)";
                try{
                    ps = con.prepareCall(sql);
                    ps.setInt(1, sucursal);
                    ps.setInt(2, p.getIdProducto());
                    ps.setInt(3, cantidad);
                    ps.executeUpdate();
                }catch (SQLException e){
                    JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
                    System.out.println(e);
                }
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
        return true;
    }
    
    public boolean buscarProducto(Producto P, int sucursal){
        con = getConexion();
        String sql = "SELECT * FROM producto P JOIN inventario I WHERE P.idProducto=I.idProducto AND I.idSucursal=? AND I.idProducto=? LIMIT 1";
        try{
            ps = con.prepareCall(sql);
            ps.setInt(1,sucursal);
            ps.setInt(2, P.getIdProducto());
            rs = ps.executeQuery();
            if(rs.next()){
                P.setIdProducto(rs.getInt(1));
                P.setNombre(rs.getString(2));
                P.setMarca(rs.getString(3));
                P.setCantidad(rs.getInt(7));
                return true;
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
        
        return false;
    }
    
    public boolean editarProducto(Producto P, int sucursal, int cantidadOriginal){
        con = getConexion();
        String sql = "SELECT * FROM producto WHERE nombre=? AND marca=? LIMIT 1";
        try{
            ps = con.prepareCall(sql);
            ps.setString(1, P.getNombre());
            ps.setString(2, P.getMarca());
            rs = ps.executeQuery();
            if (rs.next()){
                int id = rs.getInt(1);
                int cantidadProducto=rs.getInt(4);
                sql = "SELECT * FROM inventario WHERE idProducto=? AND idSucursal=? LIMIT 1";
                ps = con.prepareCall(sql);
                ps.setInt(1, id);
                ps.setInt(2, sucursal);
                rs = ps.executeQuery();
                if (rs.next()){
                    sql = "DELETE FROM inventario WHERE idProducto=? AND idSucursal=?";
                    ps = con.prepareCall(sql);
                    ps.setInt(1, P.getIdProducto());
                    ps.setInt(2, sucursal);
                    ps.executeUpdate();
                    sql = "UPDATE inventario SET cantidad=? WHERE idProducto=? AND idSucursal=?";
                    ps = con.prepareCall(sql);
                    ps.setInt(1, rs.getInt(3)+P.getCantidad());
                    ps.setInt(2, rs.getInt(2));
                    ps.setInt(3, rs.getInt(1));
                    ps.executeUpdate();
                    sql = "UPDATE producto SET cantidad=cantidad-? WHERE idProducto =?";
                    ps = con.prepareCall(sql);
                    ps.setInt(1, cantidadOriginal);
                    ps.setInt(2, P.getIdProducto());
                    ps.executeUpdate();
                    sql = "UPDATE producto SET cantidad=cantidad+? WHERE idProducto =?";
                    ps = con.prepareCall(sql);
                    ps.setInt(1, P.getCantidad());
                    ps.setInt(2, id);
                    ps.executeUpdate();
                    return true;
                }else{
                    sql = "DELETE FROM inventario WHERE idProducto=? AND idSucursal=?";
                    ps = con.prepareCall(sql);
                    ps.setInt(1, P.getIdProducto());
                    ps.setInt(2, sucursal);
                    ps.executeUpdate();
                    sql = "UPDATE producto SET cantidad=cantidad-? WHERE idProducto =?";
                    ps = con.prepareCall(sql);
                    ps.setInt(1, cantidadOriginal);
                    ps.setInt(2, P.getIdProducto());
                    ps.executeUpdate();
                    sql = "UPDATE producto SET cantidad=cantidad+? WHERE idProducto =?";
                    ps = con.prepareCall(sql);
                    ps.setInt(1, P.getCantidad());
                    ps.setInt(2, id);
                    ps.executeUpdate();
                    return nuevoProducto(P, sucursal);
                    
                }
                
            }else{
                sql = "DELETE FROM inventario WHERE idProducto=? AND idSucursal=?";
                ps = con.prepareCall(sql);
                ps.setInt(1, P.getIdProducto());
                ps.setInt(2, sucursal);
                ps.executeUpdate();
                sql = "UPDATE producto SET cantidad=cantidad-? WHERE idProducto =?";
                ps = con.prepareCall(sql);
                ps.setInt(1, cantidadOriginal);
                ps.setInt(2, P.getIdProducto());
                ps.executeUpdate();
                return nuevoProducto(P, sucursal);
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
        }
        return true;
    }
    
    public boolean editarCantidad (Producto P, int sucursal, int cantidadOriginal){
        con = getConexion();
        int cantidadAct;
        String sql = "UPDATE inventario SET cantidad=? WHERE idProducto=? AND idSucursal=?";
        try{
            ps = con.prepareCall(sql);
            ps.setInt(1, P.getCantidad());
            ps.setInt(2, P.getIdProducto());
            ps.setInt(3, sucursal);
            ps.executeUpdate();
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(e); 
        }
        sql = "SELECT * FROM producto WHERE idProducto=? LIMIT 1";
        try{
           ps = con.prepareCall(sql);
           ps.setInt(1, P.getIdProducto());
           rs = ps.executeQuery();
           if (rs.next()){
               cantidadAct =(rs.getInt(4)-cantidadOriginal)+P.getCantidad();
               sql = "UPDATE producto SET cantidad=? WHERE idProducto=?";
               ps = con.prepareCall(sql);
               ps.setInt(1, cantidadAct);
               ps.setInt(2, P.getIdProducto());
               ps.executeUpdate();
           }else{
               return false;
           }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(e); 
        }
        return true;
    }
    
    public boolean eliminarProducto(Producto P, int sucursal){
        con = getConexion();
        String sql = "DELETE FROM inventario WHERE idProducto=? AND idSucursal=?";
        try{
            ps = con.prepareCall(sql);
            ps.setInt(1, P.getIdProducto());
            ps.setInt(2, sucursal);
            ps.executeUpdate();
            sql = "UPDATE producto SET cantidad=cantidad-? WHERE idProducto =?";
            ps = con.prepareCall(sql);
            ps.setInt(1, P.getCantidad());
            ps.setInt(2, P.getIdProducto());
            ps.executeUpdate();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
            return false;
        }
        return true;
    }
}
