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

    public ControllerInventario() {
        modeloInventario = new ModelInventario();
        productos = new ArrayList<>();
    }

    /**
     * 
     * @param nombre
     * @param descripcion
     * @param unidadMedida
     * @param idProducto
     * @return un booleano al crear un objeto de la clase producto, los atributos de este
     * producto son enviados por medio del modelo a la base de datos para ser guardados
     * @throws SQLException 
     */
    public boolean agregarProducto(String nombre, String descripcion, String unidadMedida, int idProducto) throws SQLException {
        producto = new Producto();
        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setUnidadMedida(unidadMedida);
        producto.setIdProducto(idProducto);
        return modeloInventario.agregarProducto(producto, 1);
    }

    public String[][] buscar(int idProducto) {
        String[][] matrizProducto = new String[1][4];
        try {
            Producto productoEncontrado = modeloInventario.buscar(idProducto);
            matrizProducto[0][0] = Integer.toString(productoEncontrado.getIdProducto());
            matrizProducto[0][1] = productoEncontrado.getNombre();
            matrizProducto[0][2] = productoEncontrado.getDescripcion();
            matrizProducto[0][3] = productoEncontrado.getUnidadMedida();
           
            return matrizProducto;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Hubo un problema para buscar el Producto en el controlador");
        }
        return null;
    }

    public boolean actualizar(String nombre, String descripcion, String unidadMedida,
            int idProducto, int precio, int cantidad, int idProveedor) throws SQLException {
        double total = precio * cantidad; 
        producto = new Producto(nombre, descripcion, unidadMedida, precio, 
                cantidad, idProducto, idProveedor);
        return modeloInventario.actualizar(producto, total);
    }
    
    public String obtenerId() {
        return modeloInventario.obtenerId();
    }

    public String[][] refrescarTablaInventario() {

        ArrayList<Producto> tabla = modeloInventario.refrescarTabla();
        int indice = tabla.size();
        String[][] matrizProducto = new String[indice][7];
        int i = 0;
        for (Producto productoEncontrado : tabla) {
            matrizProducto[i][0] = Integer.toString(productoEncontrado.getIdProducto());
            matrizProducto[i][1] = productoEncontrado.getNombre();
            matrizProducto[i][2] = productoEncontrado.getUnidadMedida();
            matrizProducto[i][3] = Integer.toString(productoEncontrado.getPrecioUnitario());
            matrizProducto[i][4] = Integer.toString(productoEncontrado.getCantidadInventario());
            matrizProducto[i][5] = Integer.toString(productoEncontrado.getIdProveedor());
            matrizProducto[i][6] = productoEncontrado.getDescripcion();
            i++;
        }
        tabla.clear();
        return matrizProducto;
    }

    public String[][] refrescarTablaProducto() {
        ArrayList<Producto> tablaProducto = modeloInventario.refrescarTablaProducto();
        int indice = tablaProducto.size();
        String[][] matrizProducto = new String[indice][4];
        int i = 0;
        for (Producto productoEncontrado : tablaProducto) {
            matrizProducto[i][0] = Integer.toString(productoEncontrado.getIdProducto());
            matrizProducto[i][1] = productoEncontrado.getNombre();
            matrizProducto[i][2] = productoEncontrado.getUnidadMedida();
            matrizProducto[i][3] = productoEncontrado.getDescripcion();
            i++;
        }
        tablaProducto.clear();
        return matrizProducto;
    }
    
    public String[][] refrescarTablaProductoCompleta() {
        ArrayList<Producto> tablaProductoCompleta = modeloInventario.refrescarTablaProducto();
        int indice = tablaProductoCompleta.size();
        String[][] matrizProducto = new String[indice][3];
        int i = 0;
        for (Producto productoEncontrado : tablaProductoCompleta) {
            matrizProducto[i][0] = Integer.toString(productoEncontrado.getIdProducto());
            matrizProducto[i][1] = productoEncontrado.getNombre();
            matrizProducto[i][2] = productoEncontrado.getUnidadMedida();
            i++;
        }
        tablaProductoCompleta.clear();
        return matrizProducto;
    }
    
    /**
     * Metodo para rellenar la informacion que devuelve el combobox de la vista 
     * rellena con la lista de proveedores
     * @return ArrayList de String con el listado de proveedores
     */
    public ArrayList<String> obtenerListaProveedores() {
        ArrayList<String> listaProveedores = modeloInventario.obtenerListaProveedores();
        return listaProveedores;
    }

    /**
     * 
     * @param seleccionado
     * @return un entero con el numero de id del proveedor seleccionado
     * en el combobox de proveedores, para asignarlo al textfield proveedor
     */
    public int obtenerNombreProveedor(String seleccionado) {
        return modeloInventario.obtenerNombreProveedor(seleccionado);
    }
}
