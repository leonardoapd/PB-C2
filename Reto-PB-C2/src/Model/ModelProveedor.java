/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Classes.*;
import java.util.ArrayList;

/**
 *
 * @author Leonardo Perdomo
 */
public class ModelProveedor {

    ArrayList<Proveedor> tablaProveedores = new ArrayList<>();

    public ModelProveedor() {
    }

    public ArrayList<Proveedor> crear(Proveedor proveedor) {
        tablaProveedores.add(proveedor);
        return tablaProveedores;
    }

    public String[] buscar(int idProveedor, ArrayList<Proveedor> tablaProveedores) {

        String[] matrizProveedor = new String[9];

        for (Proveedor proveedorEncontrado : tablaProveedores) {
            if (proveedorEncontrado.getIdProveedor() == idProveedor) {
                matrizProveedor[0] = Integer.toString(proveedorEncontrado.getIdProveedor());
                matrizProveedor[1] = proveedorEncontrado.getNombre();
                matrizProveedor[2] = proveedorEncontrado.getDireccion();
                matrizProveedor[3] = proveedorEncontrado.getTelefono();
                matrizProveedor[4] = proveedorEncontrado.getCorreo();
                matrizProveedor[5] = proveedorEncontrado.getCiudad();
                matrizProveedor[6] = proveedorEncontrado.getDepartamento();
                matrizProveedor[7] = proveedorEncontrado.getTipoDocumento();
                matrizProveedor[8] = Integer.toString(proveedorEncontrado.getNroDocumento());
            }
        }
        return matrizProveedor;
    }

    public ArrayList<Proveedor> actualizar(Proveedor proveedorActualizado, ArrayList<Proveedor> tablaProveedores) {
        for (Proveedor proveedor : tablaProveedores) {
            proveedor.setIdProveedor(proveedorActualizado.getIdProveedor());
            proveedor.setNombre(proveedorActualizado.getNombre());
            proveedor.setDireccion(proveedorActualizado.getDireccion());
            proveedor.setCorreo(proveedorActualizado.getCorreo());
            proveedor.setCiudad(proveedorActualizado.getCiudad());
            proveedor.setDepartamento(proveedorActualizado.getDepartamento());
            proveedor.setNroDocumento(proveedorActualizado.getNroDocumento());
            proveedor.setTipoDocumento(proveedorActualizado.getTipoDocumento());
            return tablaProveedores;
        }
        return null;
    }
}
