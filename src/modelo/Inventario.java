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
public class Inventario {

    private int idSucursal;
    private int idProducto;
    private int cantidad;

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }
}
