/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.*;
import Model.*;
import java.util.ArrayList;

/**
 *
 * @author Leonardo Perdomo
 */
public class ControllerPedidos {

    private final ModelGeneral modeloGeneral;
    private ArrayList<Producto> tabla;

    public ControllerPedidos() {
        modeloGeneral = new ModelGeneral();
        tabla = new ArrayList();
    }

    public String obtenerId() {
        return modeloGeneral.obtenerId("Pedido", "pedidos");
    }

    public boolean agregarProducto(String idProducto, String idPedido) {
        return modeloGeneral.agregarProducto(Integer.parseInt(idProducto),
                Integer.parseInt(idPedido));
    }

    public String[][] refrescarTablaCrearPedido(int idPedido) {
        ArrayList<Producto> tabla = modeloGeneral.refrescarTabla(idPedido);
        int indice = tabla.size();
        String[][] matrizProducto = new String[indice][3];
        int i = 0;
        for (Producto productoEncontrado : tabla) {
            matrizProducto[i][0] = Integer.toString(productoEncontrado.getIdProducto());
            matrizProducto[i][1] = productoEncontrado.getNombre();
            matrizProducto[i][2] = productoEncontrado.getUnidadMedida();
            i++;
        }
        tabla.clear();
        return matrizProducto;
    }

    public ArrayList<Producto> agregarProducto(String[][] productoDevuelto) {
        Producto producto = new Producto();
        producto.setIdProducto(Integer.parseInt(productoDevuelto[0][0]));
        producto.setNombre(productoDevuelto[0][1]);
        producto.setUnidadMedida(productoDevuelto[0][3]);

        tabla.add(producto);
        return tabla;
    }

    public String[] organizarProductos(String [][] tablaProducto) {

        
        String[] matrizProducto = new String[3];
        
        for (String[] productoEncontrado : tablaProducto) {
            matrizProducto[0] = productoEncontrado[0];
            matrizProducto[1] = productoEncontrado[1];
            matrizProducto[2] = productoEncontrado[3];
            
        }
        return matrizProducto;
    }

    public String buscarCliente(int idCliente) {
        return modeloGeneral.buscarCliente(idCliente);
    }

}
