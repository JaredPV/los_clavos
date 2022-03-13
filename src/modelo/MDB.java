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

/**
 *
 * @author jared
 */
public class MDB extends Conexion {
    PreparedStatement ps;
    Connection con;
    ResultSet rs;
    
    
    public boolean inicioSesion (Usuario u){
        con = getConexion();
        String sql = "SELECT * FROM usuario WHERE numeroEmpleado=? AND pass=? LIMIT 1";
        try{
            ps = con.prepareCall(sql);
            ps.setInt(1, u.getNumeroEmpleado());
            ps.setString(2, u.getPass());
            rs = ps.executeQuery();
            if (rs.next()){
                u.setNumeroEmpleado(rs.getInt(1));
                u.setNombre(rs.getString(2));
                u.setPass(rs.getString(3));
                u.setAdmin(rs.getBoolean(4));
                u.setIdSucursal(rs.getInt(5));
                return true;
            }
            return false;
        }catch(SQLException e){
            System.err.println(e);
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
            System.err.println(e);
        }
        return datos;
    }
    
    public List listadoCerrado(Usuario u){
        List<Producto>datos = new ArrayList<>();
        con = getConexion();
        String sql = "SELECT * FROM producto P JOIN inventario I WHERE P.idProducto = I.idProducto AND I.idSucursal=?";
        try{
            ps = con.prepareCall(sql);
            ps.setInt(1, u.getIdSucursal());
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
            System.err.println(e);
        }
        return datos;
    }
}
