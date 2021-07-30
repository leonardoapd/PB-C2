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
    private Proveedor proveedor;

    public ControllerProveedor() {
        modeloProveedor = new ModelProveedor();
    }

    public boolean crear(String nombre, String direccion, String telefono, String correo,
            String ciudad, String departamento, String tipoDocumento, int nroDocumento,
            int idProveedor) {
        proveedor = new Proveedor(nombre, direccion, telefono, correo, ciudad, departamento,
                tipoDocumento, nroDocumento, idProveedor);
        return modeloProveedor.crear(proveedor);
    }

    public String[] buscar(int idProveedor) {
        String[] matrizProveedor = new String[10];
        try {
            Proveedor proveedorEncontrado = modeloProveedor.buscar(idProveedor);
            matrizProveedor[0] = Integer.toString(proveedorEncontrado.getIdProveedor());
            matrizProveedor[1] = proveedorEncontrado.getNombre();
            matrizProveedor[2] = proveedorEncontrado.getDireccion();
            matrizProveedor[3] = proveedorEncontrado.getTelefono();
            matrizProveedor[4] = proveedorEncontrado.getCorreo();
            matrizProveedor[5] = proveedorEncontrado.getCiudad();
            matrizProveedor[6] = proveedorEncontrado.getDepartamento();
            matrizProveedor[7] = proveedorEncontrado.getTipoDocumento();
            matrizProveedor[8] = Integer.toString(proveedorEncontrado.getNroDocumento());
            return matrizProveedor;
        } catch (Exception e) {
            System.out.println("Hubo un problema para buscar el proveedor en el controlador");
        }
        return null;
    }

    public boolean actualizar(String nombre, String direccion, String telefono, String correo,
            String ciudad, String departamento, String tipoDocumento, int nroDocumento,
            int idProveedor) {
        proveedor = new Proveedor(nombre, direccion, telefono, correo, ciudad, departamento,
                tipoDocumento, nroDocumento, idProveedor);
        return modeloProveedor.actualizar(proveedor);
    }

    public String[][] refrescarTablaProveedor() {
        
        ArrayList<Proveedor> tabla = modeloProveedor.refrescarTabla();
        int indice = tabla.size();
        String[][] matrizProveedor = new String[indice][9];
        int i = 0;
        for (Proveedor proveedorEncontrado : tabla) {
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
        tabla.clear();
        return matrizProveedor;
    }

}
