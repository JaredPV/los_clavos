package los_clavos;

import controlador.Controlador;
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


public class Los_clavos {

    public static void main(String[] args) {
        // MODELOS
        Usuario MUsuario = new Usuario();
        Producto MProducto = new Producto();
        Sucursal MSucursal = new Sucursal();
        MDB MMDB = new MDB();
        
        // VISTAS
        SignIn VSign = new SignIn();
        Inicio VInicio = new Inicio();
        Reportes VReportes = new Reportes();
        Sucursales VSucursales = new Sucursales();
        Inventario VInventario = new Inventario();
        NuevoProducto VNuevo = new NuevoProducto();
        EditarProducto VEditar = new EditarProducto();
        Controlador ctrl = new Controlador(MUsuario, MProducto, MSucursal, MMDB, VSign, VInicio, VReportes, VSucursales, VInventario, VNuevo, VEditar);
        ctrl.iniciar();
    }
    
}
