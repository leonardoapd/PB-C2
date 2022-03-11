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


public class Pedido {
    //Se crean los atributos de la clase
    private int idPedido, descuento;
    private EstadoPedido estadoPedido;
    private int [] idProducto, idCliente, idVendedor;

    //Se crea el constructor de la clase
    public Pedido(int idPedido, int descuento, EstadoPedido estadoPedido, int[] idProducto, int[] idCliente, int[] idVendedor) {
        this.idPedido = idPedido;
        this.descuento = descuento;
        this.estadoPedido = estadoPedido;
        this.idProducto = idProducto;
        this.idCliente = idCliente;
        this.idVendedor = idVendedor;
    }
    
    //Se crean los get y los set
    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public int[] getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int[] idProducto) {
        this.idProducto = idProducto;
    }

    public int[] getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int[] idCliente) {
        this.idCliente = idCliente;
    }

    public int[] getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int[] idVendedor) {
        this.idVendedor = idVendedor;
    }
    
}
