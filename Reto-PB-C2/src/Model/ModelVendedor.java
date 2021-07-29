/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Classes.*;
import java.util.*;

/**
 *
 * @author Leonardo Perdomo
 */
public class ModelVendedor {

    ArrayList<Vendedor> tablaVendedores = new ArrayList<>();

    public ModelVendedor() {
    }

    public ArrayList<Vendedor> crear(Vendedor vendedor) {
        tablaVendedores.add(vendedor);
        return tablaVendedores;
    }

    public String[] buscar(int idVendedor, ArrayList<Vendedor> tablaVendedores) {

        String[] matrizVendedor = new String[9];

        for (Vendedor vendedorEncontrado : tablaVendedores) {
            if (vendedorEncontrado.getIdVendedor() == idVendedor) {
                matrizVendedor[0] = Integer.toString(vendedorEncontrado.getIdVendedor());
                matrizVendedor[1] = vendedorEncontrado.getNombre();
                matrizVendedor[2] = vendedorEncontrado.getDireccion();
                matrizVendedor[3] = vendedorEncontrado.getTelefono();
                matrizVendedor[4] = vendedorEncontrado.getCorreo();
                matrizVendedor[5] = vendedorEncontrado.getCiudad();
                matrizVendedor[6] = vendedorEncontrado.getDepartamento();
                matrizVendedor[7] = vendedorEncontrado.getTipoDocumento();
                matrizVendedor[8] = Integer.toString(vendedorEncontrado.getNroDocumento());
            }
        }
        return matrizVendedor;
    }

    public ArrayList<Vendedor> actualizar(Vendedor vendedorActualizado, ArrayList<Vendedor> tablaVendedores) {
        for (Vendedor vendedor : tablaVendedores) {
                vendedor.setIdVendedor(vendedorActualizado.getIdVendedor());
                vendedor.setNombre(vendedorActualizado.getNombre());
                vendedor.setDireccion(vendedorActualizado.getDireccion());
                vendedor.setCorreo(vendedorActualizado.getCorreo());
                vendedor.setCiudad(vendedorActualizado.getCiudad());
                vendedor.setDepartamento(vendedorActualizado.getDepartamento());
                vendedor.setNroDocumento(vendedorActualizado.getNroDocumento());
                vendedor.setTipoDocumento(vendedorActualizado.getTipoDocumento());
                return tablaVendedores;
            }
        return null;
    }
}
