
package modelo;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {
    private String base = "losclavos";
    private String user = "usuariojared";
    private String password = "administrador";
    private String url = "jdbc:mysql://localhost:3306/"+base;
    private Connection con = null;

    public Connection getConexion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);
            JOptionPane.showMessageDialog(null, "conectado");
        }catch (SQLException e){
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "error");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
