 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.List;

/**
 *
 * @author Leonardo Perdomo
 */
public class Inventario {
    //Atributos
    private List<Producto> producto;
    private int idInventario;
    private List<Pedido> pedido;
    private List<Venta> venta;
    //private Paquete [] paquete;
    
    //Constructor
    public Inventario(List<Producto> producto, int idInventario) {
        this.producto = producto;
        this.idInventario = idInventario;
    }
    
    //Metodos

    public List<Producto> getProducto() {
        return producto;
    }

    public void setProducto(List<Producto> producto) {
        this.producto = producto;
    }

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public List<Pedido> getPedido() {
        return pedido;
    }

    public void setPedido(List<Pedido> pedido) {
        this.pedido = pedido;
    }

    public List<Venta> getVenta() {
        return venta;
    }

    public void setVenta(List<Venta> venta) {
        this.venta = venta;
    }
    
    
}
