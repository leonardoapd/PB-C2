/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Leonardo Perdomo
 */
public class Inventario {
    //Atributos
    private Producto [] producto;
    private int idInventario;
    private Pedido [] pedido;
    private Venta [] venta;
    //private Paquete [] paquete;
    
    //Constructor
    public Inventario(Producto[] producto, int idInventario) {
        this.producto = producto;
        this.idInventario = idInventario;
    }
    
    //Metodos
    public Producto[] getProducto() {
        return producto;
    }

    public void setProducto(Producto[] producto) {
        this.producto = producto;
    }

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public Pedido[] getPedido() {
        return pedido;
    }

    public void setPedido(Pedido[] pedido) {
        this.pedido = pedido;
    }

    public Venta[] getVenta() {
        return venta;
    }

    public void setVenta(Venta[] venta) {
        this.venta = venta;
    }
    
    
}
