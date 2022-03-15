package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.MDB;
import modelo.Producto;
import modelo.Sucursal;
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
    public Producto MProducto;
    public Sucursal MSucursal;
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
    public Controlador (Usuario MUsuario, Producto MProducto, Sucursal MSucursal, MDB MMDB, SignIn VSign, Inicio VInicio, Reportes VReportes, Sucursales VSucursales, Inventario VInventario, NuevoProducto VNuevo, EditarProducto VEditar){
        // VARIABLES DE MODELOS
        this.MUsuario = MUsuario;
        this.MProducto = MProducto;
        this.MSucursal = MSucursal;
        this.MMDB = MMDB;
        // VARIABLES DE VISTAS
        this.VInicio = VInicio;
        this.VSign = VSign;
        this.VReportes = VReportes;
        this.VSucursales = VSucursales;
        this.VInventario = VInventario;
        this.VNuevo = VNuevo;
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
        this.VInventario.btnEditar.addActionListener(this);
        this.VInventario.btnInicio.addActionListener(this);
        this.VInventario.btnReportes.addActionListener(this);
        this.VNuevo.btnAgregar.addActionListener(this);
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
        VSucursales.lblEmpleado.setText(MUsuario.getNombre());
        VSucursales.setVisible(true);
    }
    
    public void iniciarInventario(JTable tabla, int seleccion){
        modelo.setRowCount(0);
        
        if (seleccion == 0){
            VInventario.btnEditar.setEnabled(false);
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
            VInventario.setTitle("INVENTARIO GENERAL");
            
        }else{
            VInventario.btnEditar.setEnabled(true);
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
        
        
        VInventario.setLocationRelativeTo(null);
        VInventario.lblEmpleado.setText(MUsuario.getNombre());
        VInventario.setVisible(true);
    }
    
    public void iniciarNuevoP(){
        VNuevo.txtMarca.setText(null);
        VNuevo.txtNombre.setText(null);
        VNuevo.txtUnidades.setText(null);
        VNuevo.setTitle("NUEVO PRODUCTO");
        VNuevo.setLocationRelativeTo(null);
        VNuevo.setVisible(true);
        if(!MUsuario.isAdmin()){
           VNuevo.cbTienda.setSelectedIndex(MUsuario.getIdSucursal()-1);
           VNuevo.cbTienda.disable();
        }else{
            VNuevo.cbTienda.setSelectedIndex(MUsuario.getIdSucursal()-1);
            VNuevo.cbTienda.enable();
        }
    }
    
    public void iniciarEditarP(){
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==VSign.btnEntrar){
            if(VSign.txtEmpleado.getText().isEmpty() || VSign.txtPass.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Campo(s) no rellenado(s)", "INFORMACIÓN NECESARIA",JOptionPane.WARNING_MESSAGE);
            } else {
                
                if(MMDB.inicioSesion(VSign.txtEmpleado.getText(), VSign.txtPass.getText(), MUsuario, MSucursal)){
                    JOptionPane.showMessageDialog(null, "Conectado al sistema","ESTADO DE CONEXIÓN",JOptionPane.INFORMATION_MESSAGE);
                    this.VSign.dispose();
                    iniciarInicio();
                }else{
                    JOptionPane.showMessageDialog(null, "Usuario no econtrado", "ERROR", JOptionPane.ERROR_MESSAGE);
                    VSign.txtEmpleado.setText("");
                    VSign.txtPass.setText("");
                }
           }
            
       }else if (e.getSource()==VInicio.btnReportes){
           VInicio.dispose();
           iniciarReportes();
       }else if (e.getSource()==VInicio.btnInventario){
           if(MUsuario.isAdmin()){
               VInicio.dispose();
               iniciarSucursales();
           }else{
               VInventario.setTitle("INVENTARIO "+ MSucursal.getNombre().toUpperCase());
               VInventario.lblInventario.setText("Inventario "+MSucursal.getNombre());
               VInicio.dispose();
               iniciarInventario(VInventario.tabla, MUsuario.getIdSucursal());
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
               VReportes.dispose();
               iniciarSucursales();
           }else{
               VInventario.setTitle("INVENTARIO "+ MSucursal.getNombre().toUpperCase());
               VInventario.lblInventario.setText("Inventario "+MSucursal.getNombre());
               VReportes.dispose();
               iniciarInventario(VInventario.tabla, MUsuario.getIdSucursal());
           }
       }
       if(e.getSource()==VSucursales.btnInicio){
           VSucursales.dispose();
           iniciarInicio();
       }else if(e.getSource()==VSucursales.btnReportes){
           VSucursales.dispose();
           iniciarReportes();           
       }else if(e.getSource()==VSucursales.btnActopan){
           sucursalSeleccionada = 1;
           VInventario.setTitle("INVENTARIO ACTOPAN");
           VInventario.lblInventario.setText("Inventario Actopan");
           VSucursales.dispose();
           iniciarInventario(VInventario.tabla, sucursalSeleccionada);
       }else if(e.getSource()==VSucursales.btnMineral){
           sucursalSeleccionada = 2;
           VInventario.setTitle("INVENTARIO MINERAL DE LA REFORMA");
           VInventario.lblInventario.setText("Inventario Mineral de la Reforma");
           VSucursales.dispose();
           iniciarInventario(VInventario.tabla, sucursalSeleccionada);
       }else if(e.getSource()==VSucursales.btnPachuca1){
           sucursalSeleccionada = 3;
           VInventario.setTitle("INVENTARIO PACHUCA II");
           VInventario.lblInventario.setText("Inventario Pachuca I");
           VSucursales.dispose();
           iniciarInventario(VInventario.tabla, sucursalSeleccionada);
       }else if(e.getSource()==VSucursales.btnPachuca2){
           sucursalSeleccionada = 4;
           VInventario.setTitle("INVENTARIO PACHUCA II");
           VInventario.lblInventario.setText("Inventario Pachuca II");
           VSucursales.dispose();
           iniciarInventario(VInventario.tabla, sucursalSeleccionada);
       }else if(e.getSource()==VSucursales.btnZempoala){
           sucursalSeleccionada = 5;
           VInventario.setTitle("INVENTARIO ZEMPOALA");
           VInventario.lblInventario.setText("Inventario Zempoala");
           VSucursales.dispose();
           iniciarInventario(VInventario.tabla, sucursalSeleccionada);
       }else if(e.getSource()==VSucursales.btnGeneral){
           sucursalSeleccionada = 0;
           VInventario.setTitle("INVENTARIO GENERAL");
           VInventario.lblInventario.setText("Inventario General");
           VSucursales.dispose();
           iniciarInventario(VInventario.tabla, sucursalSeleccionada);
       }
       if(e.getSource()==VInventario.btnNuevo){
           VInventario.dispose();
           iniciarNuevoP();
       }else if (e.getSource()==VInventario.btnEditar){
           VInventario.dispose();
       }else if (e.getSource()==VInventario.btnInicio){
           VInventario.dispose();
           iniciarInicio();
       }else if (e.getSource()==VInventario.btnReportes){
           VInventario.dispose();
           iniciarReportes();
       }
       if(e.getSource()==VNuevo.btnAgregar){
           MProducto.setNombre(VNuevo.txtNombre.getText().toUpperCase());
           MProducto.setMarca(VNuevo.txtMarca.getText().toUpperCase());
           MProducto.setCantidad(Integer.parseInt(VNuevo.txtUnidades.getText()));
           if(MMDB.nuevoProducto(MProducto, MUsuario, VNuevo.cbTienda.getSelectedIndex()+1)){
               JOptionPane.showMessageDialog(null, "Nuevo registro exitoso","ESTADO DE REGISTRO",JOptionPane.INFORMATION_MESSAGE);
           }else{
               JOptionPane.showMessageDialog(null, "El producto ya existe en la sucursal seleccionada", "ESTADO DE REGISTRO", JOptionPane.ERROR_MESSAGE);
           }
           VNuevo.dispose();
           iniciarInicio();
       }
    }
    public static void main (String[] arg){
          
    }
}
