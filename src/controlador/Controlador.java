package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.MDB;
import modelo.Producto;
import modelo.Usuario;
import vista.EditarProducto;
import vista.Inicio;
import vista.Inventario;
import vista.NuevoProducto;
import vista.Reportes;
import vista.SignIn;
import vista.Sucursales;

public class Controlador implements ActionListener{
    // VARIABLES DE MODELOS
    public Usuario MUsuario;
    public MDB MMDB;
    // VARIABLES DE VISTAS
    public SignIn VSign;
    public Inicio VInicio;
    public Reportes VReportes;
    public Sucursales VSucursales;
    public Inventario VInventario;
    public NuevoProducto VNuevo;
    public EditarProducto VEditar;
    
    public int sucursalSeleccionada;
    public DefaultTableModel modelo = new DefaultTableModel();
    public Controlador (Usuario MUsuario, MDB MMDB, SignIn VSign, Inicio VInicio, Reportes VReportes, Sucursales VSucursales, Inventario VInventario, NuevoProducto VNuevo, EditarProducto VEditar){
        // VARIABLES DE MODELOS
        this.MUsuario = MUsuario;
        this.MMDB = MMDB;
        // VARIABLES DE VISTAS
        this.VInicio = VInicio;
        this.VSign = VSign;
        this.VNuevo = VNuevo;
        this.VReportes = VReportes;
        this.VSucursales = VSucursales;
        this.VInventario = VInventario;
        // VARIABLES BOTONES
        this.VSign.btnEntrar.addActionListener(this);
        this.VInicio.btnInventario.addActionListener(this);
        this.VInicio.btnReportes.addActionListener(this);
        this.VInicio.btnSalir.addActionListener(this);
        this.VReportes.btnInicio.addActionListener(this);
        this.VReportes.btnInventario.addActionListener(this);
        this.VSucursales.btnInicio.addActionListener(this);
        this.VSucursales.btnReportes.addActionListener(this);
        this.VSucursales.btnActopan.addActionListener(this);
        this.VSucursales.btnMineral.addActionListener(this);
        this.VSucursales.btnPachuca1.addActionListener(this);
        this.VSucursales.btnPachuca2.addActionListener(this);
        this.VSucursales.btnZempoala.addActionListener(this);
        this.VSucursales.btnGeneral.addActionListener(this);
        this.VInventario.btnNuevo.addActionListener(this);
        
    }
    
    public void iniciar(){
        this.VSign.txtEmpleado.setText(null);
        this.VSign.txtPass.setText(null);
        this.VSign.setTitle("INICIO SESIÓN LOS CLAVOS");
        this.VSign.setLocationRelativeTo(null);
        this.VSign.setVisible(true);
        
    }
    
    public void iniciarInicio(){
        VInicio.setTitle("INICIO");
        VInicio.setLocationRelativeTo(null);
        VInicio.lblNombre.setText(MUsuario.getNombre());
        VInicio.setVisible(true);
    }
    
    public void iniciarReportes(){
        VReportes.setTitle("REPORTES");
        VReportes.setLocationRelativeTo(null);
        VReportes.lblEmpleado.setText(MUsuario.getNombre());
        VReportes.setVisible(true);
    }
    
    public void iniciarSucursales(){
        VSucursales.setTitle("SELECCIONAR SUCURSAL");
        VSucursales.setLocationRelativeTo(null);
        VSucursales.setVisible(true);
    }
    
    public void iniciarInventario(JTable tabla, int seleccion){
        if (seleccion == 0){
            modelo = (DefaultTableModel)tabla.getModel();
            List<Producto>lista = MMDB.listadoAbierto();
            Object[]objeto = new Object[4];
            for (int i=0; i<lista.size(); i++){
                objeto[0]=lista.get(i).getIdProducto();
                objeto[1]=lista.get(i).getNombre();
                objeto[2]=lista.get(i).getMarca();
                objeto[3]=lista.get(i).getCantidad();
                modelo.addRow(objeto);
            }
            VInventario.tabla.setModel(modelo);
        }else{
            modelo = (DefaultTableModel)tabla.getModel();
            List<Producto>lista = MMDB.listadoCerrado(MUsuario, seleccion);
            Object[]objeto = new Object[4];
            for (int i=0; i<lista.size(); i++){
                objeto[0]=lista.get(i).getIdProducto();
                objeto[1]=lista.get(i).getNombre();
                objeto[2]=lista.get(i).getMarca();
                objeto[3]=lista.get(i).getCantidad();
                modelo.addRow(objeto);
            }
            VInventario.tabla.setModel(modelo);
        }
        
        this.VInventario.setTitle("INVENTARIO GENERAL");
        this.VInventario.setLocationRelativeTo(null);
        VInventario.setVisible(true);
    }
    
    public void iniciarNuevoP(){
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==VSign.btnEntrar){
           System.out.println("enter works");
            if(MMDB.inicioSesion(VSign.txtEmpleado.getText(), VSign.txtPass.getText(), MUsuario)){
                JOptionPane.showMessageDialog(null, "conectado");
                this.VSign.dispose();
                iniciarInicio();
            }else{
                JOptionPane.showMessageDialog(null, "usuario no encontrado");
                this.VSign.txtEmpleado.setText("");
                this.VSign.txtPass.setText("");
            }
       }else if (e.getSource()==VInicio.btnReportes){
           VInicio.dispose();
           iniciarReportes();
       }else if (e.getSource()==VInicio.btnInventario){
           if(MUsuario.isAdmin()){
               VInicio.dispose();
               iniciarSucursales();
           }else{
               
           }
       }else if (e.getSource()==VInicio.btnSalir){
           VInicio.dispose();
           iniciar();
       }
       if(e.getSource()==VReportes.btnInicio){
           VReportes.dispose();
           iniciarInicio();
       }else if (e.getSource()==VReportes.btnInventario){
           if(MUsuario.isAdmin()){
               VInicio.dispose();
               iniciarSucursales();
           }else{
               
           }
       }
       if(e.getSource()==VSucursales.btnInicio){
           
       }else if(e.getSource()==VSucursales.btnReportes){
           
       }else if(e.getSource()==VSucursales.btnActopan){
           sucursalSeleccionada = 1;
           iniciarInventario(VInventario.tabla, sucursalSeleccionada);
       }else if(e.getSource()==VSucursales.btnMineral){
           sucursalSeleccionada = 2;
           iniciarInventario(VInventario.tabla, sucursalSeleccionada);
       }else if(e.getSource()==VSucursales.btnPachuca1){
           sucursalSeleccionada = 3;
           iniciarInventario(VInventario.tabla, sucursalSeleccionada);
       }else if(e.getSource()==VSucursales.btnPachuca2){
           sucursalSeleccionada = 4;
           iniciarInventario(VInventario.tabla, sucursalSeleccionada);
       }else if(e.getSource()==VSucursales.btnZempoala){
           sucursalSeleccionada = 5;
           iniciarInventario(VInventario.tabla, sucursalSeleccionada);
       }else if(e.getSource()==VSucursales.btnGeneral){
           sucursalSeleccionada = 0;
           iniciarInventario(VInventario.tabla, sucursalSeleccionada);
       }
       if(e.getSource()==VInventario.btnNuevo){
           this.VInventario.dispose();
           iniciarNuevoP();
       }else if (e.getSource()==VInventario.btnEditar){
           
       }
    }
    public static void main (String[] arg){
          
    }
}
