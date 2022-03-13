/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author jared
 */
public class Usuario {
    private int numeroEmpleado;
    private String nombre;
    private String pass;
    private boolean admin;
    private int idSucursal;

    public void setNumeroEmpleado(int numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public int getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPass() {
        return pass;
    }

    public boolean isAdmin() {
        return admin;
    }

    public int getIdSucursal() {
        return idSucursal;
    }
}
