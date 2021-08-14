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
public class Producto {
    
    //Se crean los atributos de la clase
    private String nombre, descripcion, unidadMedida;
    private int precioUnitario, cantidadInventario, idProducto, idProveedor;

    
    //Se crea el constructor de la clase
    public Producto(String nombre, String descripcion, String unidadMedida, 
            int precioUnitario, int cantidadInventario, int idProducto, int idProveedor) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.unidadMedida = unidadMedida;
        this.precioUnitario = precioUnitario;
        this.cantidadInventario = cantidadInventario;
        this.idProducto = idProducto;
        this.idProveedor = idProveedor;
    }
    
    public Producto() {
        
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    //Se crean los get y los set
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

    public int getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(int precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCantidadInventario() {
        return cantidadInventario;
    }

    public void setCantidadInventario(int cantidadInventario) {
        this.cantidadInventario = cantidadInventario;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    
    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }
 
    
}
