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
public class Paquete {
    //Atributos
    private int [] idProducto;
    private int idPaquete, precio;
    private String nombre, descripcion;
    private float descuento;
    
    //Constructor

    public Paquete(int[] idProducto, int idPaquete, int precio, String nombre, String descripcion, float descuento) {
        this.idProducto = idProducto;
        this.idPaquete = idPaquete;
        this.precio = precio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.descuento = descuento;
    }
    
}
