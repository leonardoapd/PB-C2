 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leonardo Perdomo
 */
public class Inventario {
    //Atributos
    private ArrayList<Producto> producto;
    private int idInventario;
    private ArrayList<Pedido> pedido;
    private ArrayList<Venta> venta;
    //private Paquete [] paquete;
    
    //Constructor
    public Inventario(ArrayList<Producto> producto, int idInventario) {
        this.producto = producto;
        this.idInventario = idInventario;
    }
    
    //Metodos

    public ArrayList<Producto> getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto.add(producto);
    }

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public ArrayList<Pedido> getPedido() {
        return pedido;
    }

    public void setPedido(ArrayList<Pedido> pedido) {
        this.pedido = pedido;
    }

    public ArrayList<Venta> getVenta() {
        return venta;
    }

    public void setVenta(ArrayList<Venta> venta) {
        this.venta = venta;
    }
    
    
}
