/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.*;
import Model.*;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Leonardo Perdomo
 */
public class ControllerInventario {

    ArrayList<Producto> productos;
    private final ModelInventario modeloInventario;
    private Producto producto;
    private Inventario inventario;

    public ControllerInventario() {
        modeloInventario = new ModelInventario();
        productos = new ArrayList<>();
    }

    /*
    public boolean crearInventario() {
        modeloInventario.crearInventario(productos, 1);
        return true;
    }
    */
    
    public boolean agregarProducto(String nombre, String descripcion, int precio, int cantidad, int idProducto, int idProveedor) throws SQLException {
        producto = new Producto(nombre, descripcion, precio, cantidad, idProducto, idProveedor);
          
        return modeloInventario.agregarProducto(producto, 1);
    }
    
    //TODO
    public String[] buscar(int idProducto) {
        String[] matrizProducto = new String[6];
        try {
            Producto productoEncontrado = modeloInventario.buscar(idProducto);
            matrizProducto[0] = Integer.toString(productoEncontrado.getIdProducto());
            matrizProducto[1] = productoEncontrado.getNombre();
            matrizProducto[2] = productoEncontrado.getDescripcion();
            matrizProducto[3] = Integer.toString(productoEncontrado.getPrecioUnitario());
            matrizProducto[4] = Integer.toString(productoEncontrado.getCantidadInventario());
            matrizProducto[5] = Integer.toString(productoEncontrado.getIdProveedor());
            
            return matrizProducto;
        } catch (Exception e) {
            System.out.println("Hubo un problema para buscar el Producto en el controlador");
        }
        return null;
    }
    
    public boolean actualizar(String nombre, String descripcion, int precio, int cantidad, int idProducto, int idProveedor) throws SQLException {
        producto = new Producto(nombre, descripcion, precio, cantidad, idProducto, idProveedor);
          
        return modeloInventario.actualizar(producto);
    }
    
    

    public String[][] refrescarTablaInventario() {
        
        ArrayList<Producto> tabla = modeloInventario.refrescarTabla();
        int indice = tabla.size();
        String[][] matrizProducto = new String[indice][6];
        int i = 0;
        for (Producto productoEncontrado : tabla) {
            matrizProducto[i][0] = Integer.toString(productoEncontrado.getIdProducto());
            matrizProducto[i][1] = productoEncontrado.getNombre();
            matrizProducto[i][2] = Integer.toString(productoEncontrado.getPrecioUnitario());
            matrizProducto[i][3] = Integer.toString(productoEncontrado.getCantidadInventario());            
            matrizProducto[i][4] = Integer.toString(productoEncontrado.getIdProveedor());
            matrizProducto[i][5] = productoEncontrado.getDescripcion();
            i++;
        }
        tabla.clear();
        return matrizProducto;
    }
}
