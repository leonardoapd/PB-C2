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
public class ControllerProveedor {

    private final ModelProveedor modeloProveedor;
    private ArrayList<Proveedor> tablaVendedores;
    private Proveedor proveedor;

    public ControllerProveedor() {
        modeloProveedor = new ModelProveedor();
        tablaVendedores = new ArrayList<>();
    }

    public boolean crear(String nombre, String direccion, String telefono, String correo,
            String ciudad, String departamento, String tipoDocumento, int nroDocumento,
            int idProveedor) {
        proveedor = new Proveedor(nombre, direccion, telefono, correo, ciudad, departamento,
                tipoDocumento, nroDocumento, idProveedor);
        tablaVendedores = modeloProveedor.crear(proveedor);
        return true;
    }

    public String[] buscar(int idProveedor) {
        try {
            return modeloProveedor.buscar(idProveedor, tablaVendedores);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean actualizar(String nombre, String direccion, String telefono, String correo,
            String ciudad, String departamento, String tipoDocumento, int nroDocumento,
            int idProveedor) {
        proveedor = new Proveedor(nombre, direccion, telefono, correo, ciudad, departamento,
                tipoDocumento, nroDocumento, idProveedor);
        tablaVendedores = modeloProveedor.actualizar(proveedor, tablaVendedores);
        return true;

    }

    public String[][] refrescarTablaProveedor() {
        int indice = tablaVendedores.size();
        String[][] matrizProveedor = new String[indice][9];
        int i = 0;
        for (Proveedor proveedorEncontrado : tablaVendedores) {
            matrizProveedor[i][0] = Integer.toString(proveedorEncontrado.getIdProveedor());
            matrizProveedor[i][1] = proveedorEncontrado.getNombre();
            matrizProveedor[i][2] = proveedorEncontrado.getDireccion();
            matrizProveedor[i][3] = proveedorEncontrado.getTelefono();
            matrizProveedor[i][4] = proveedorEncontrado.getCorreo();
            matrizProveedor[i][5] = proveedorEncontrado.getCiudad();
            matrizProveedor[i][6] = proveedorEncontrado.getDepartamento();
            matrizProveedor[i][7] = proveedorEncontrado.getTipoDocumento();
            matrizProveedor[i][8] = Integer.toString(proveedorEncontrado.getNroDocumento());
            i++;
        }
        return matrizProveedor;
    }

}
