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
public class Venta {
    //Atributos
    private int valorTotal, idVenta;
    private String fechaVenta;
    private Pedido pedido;
    
    //Constructor
    public Venta(int valorTotal, int idVenta, String fechaVenta, Pedido pedido) {
        this.valorTotal = valorTotal;
        this.idVenta = idVenta;
        this.fechaVenta = fechaVenta;
        this.pedido = pedido;
    }
    
    public Venta() {
        //Constructor vacio
    }
    
    //get y set
    public int getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
}
