/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.*;
import Model.*;
import java.util.*;

/**
 *
 * @author Leonardo Perdomo
 */
public class ControllerVendedor {

    private final ModelVendedor modeloVendedor;
    private ArrayList<Vendedor> tablaVendedores;
    private Vendedor vendedor;

    public ControllerVendedor() {
        modeloVendedor = new ModelVendedor();
        tablaVendedores = new ArrayList<>();
    }

    public boolean crear(String nombre, String direccion, String telefono, String correo,
            String ciudad, String departamento, String tipoDocumento, int nroDocumento,
            int idVendedor) {
        vendedor = new Vendedor(nombre, direccion, telefono, correo, ciudad, departamento,
                tipoDocumento, nroDocumento, idVendedor);
        tablaVendedores = modeloVendedor.crear(vendedor);
        return true;
    }

    public String[] buscar(int idVendedor) {
        try {
            return modeloVendedor.buscar(idVendedor, tablaVendedores);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean actualizar(String nombre, String direccion, String telefono, String correo,
            String ciudad, String departamento, String tipoDocumento, int nroDocumento,
            int idVendedor) {
        vendedor = new Vendedor(nombre, direccion, telefono, correo, ciudad, departamento,
                tipoDocumento, nroDocumento, idVendedor);
        tablaVendedores = modeloVendedor.actualizar(vendedor, tablaVendedores);
        return true;

    }

    public String[][] refrescarTablaVendedor() {
        int indice = tablaVendedores.size();
        String[][] matrizVendedor = new String[indice][9];
        int i = 0;
        for (Vendedor vendedorEncontrado : tablaVendedores) {
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
        return matrizVendedor;
    }
}
