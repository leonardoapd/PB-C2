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
public class Paquete {
    //Atributos
    private final List<Integer> idProductos;
    private int idPaquete;
    private String nombre, descripcion;
    private double descuento, precio;
    
    //Constructor
    public Paquete(List<Integer> idProductos, int idPaquete, double precio, String nombre, String descripcion, double descuento) {
        this.idProductos = idProductos;
        this.idPaquete = idPaquete;
        this.precio = precio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.descuento = 0;
    }

    //get and set
    public List<Integer> getIdProductos() {
        return idProductos;
    }

    public void setIdProducto(int idProducto) {
        this.idProductos.add(idProducto);
    }

    public int getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(int idPaquete) {
        this.idPaquete = idPaquete;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
  
}
