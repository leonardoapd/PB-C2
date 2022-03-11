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
public class ControllerVendedor {

    private final ModelVendedor modeloVendedor;
    private Vendedor vendedor;

    public ControllerVendedor() {
        modeloVendedor = new ModelVendedor();
    }

    public boolean crear(String nombre, String direccion, String telefono, String correo,
            String ciudad, String departamento, String tipoDocumento, int nroDocumento,
            int idVendedor) {
        vendedor = new Vendedor(nombre, direccion, telefono, correo, ciudad, departamento,
                tipoDocumento, nroDocumento, idVendedor);
        return modeloVendedor.crear(vendedor);
    }

    public String[] buscar(int idVendedor) {
        String[] matrizVendedor = new String[9];
        try {
            Vendedor vendedorEncontrado = modeloVendedor.buscar(idVendedor);
            matrizVendedor[0] = Integer.toString(vendedorEncontrado.getIdVendedor());
            matrizVendedor[1] = vendedorEncontrado.getNombre();
            matrizVendedor[2] = vendedorEncontrado.getDireccion();
            matrizVendedor[3] = vendedorEncontrado.getTelefono();
            matrizVendedor[4] = vendedorEncontrado.getCorreo();
            matrizVendedor[5] = vendedorEncontrado.getCiudad();
            matrizVendedor[6] = vendedorEncontrado.getDepartamento();
            matrizVendedor[7] = vendedorEncontrado.getTipoDocumento();
            matrizVendedor[8] = Integer.toString(vendedorEncontrado.getNroDocumento());
            return matrizVendedor;
        } catch (Exception e) {
            System.out.println("Hubo un problema para buscar el vendedor en el controlador");
        }
        return null;
    }

    public boolean actualizar(String nombre, String direccion, String telefono, String correo,
            String ciudad, String departamento, String tipoDocumento, int nroDocumento,
            int idVendedor) {
        vendedor = new Vendedor(nombre, direccion, telefono, correo, 
                ciudad, departamento, tipoDocumento, nroDocumento,
                idVendedor);
        return modeloVendedor.actualizar(vendedor);
    }

    public String[][] refrescarTablaVendedor() {
        
        ArrayList<Vendedor> tabla = modeloVendedor.refrescarTabla();
        int indice = tabla.size();
        String[][] matrizVendedor = new String[indice][9];
        int i = 0;
        for (Vendedor vendedorEncontrado : tabla) {
            matrizVendedor[i][0] = Integer.toString(vendedorEncontrado.getIdVendedor());
            matrizVendedor[i][1] = vendedorEncontrado.getNombre();
            matrizVendedor[i][2] = vendedorEncontrado.getDireccion();
            matrizVendedor[i][3] = vendedorEncontrado.getTelefono();
            matrizVendedor[i][4] = vendedorEncontrado.getCorreo();
            matrizVendedor[i][5] = vendedorEncontrado.getCiudad();
            matrizVendedor[i][6] = vendedorEncontrado.getDepartamento();
            matrizVendedor[i][7] = vendedorEncontrado.getTipoDocumento();
            matrizVendedor[i][8] = Integer.toString(vendedorEncontrado.getNroDocumento());
            i++;
        }
        tabla.clear();
        return matrizVendedor;
    }

}
