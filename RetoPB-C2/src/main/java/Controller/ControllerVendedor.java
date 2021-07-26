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

    ModelVendedor modeloVendedor;
    Vendedor vendedor;

    public ControllerVendedor() {
        modeloVendedor = new ModelVendedor();
    }

    public void procesar(String nombre, String direccion, String telefono, String correo,
            String ciudad, String departamento, String tipoDocumento, int nroDocumento,
            int idVendedor) {

        vendedor = new Vendedor(nombre, direccion, telefono, correo, ciudad, departamento,
                tipoDocumento, nroDocumento, idVendedor);

    }

    public boolean crear(List<Vendedor> listaVendedores) {
        vendedor.crear(vendedor.getNombre(), vendedor.getDireccion(), vendedor.getTelefono(),
                vendedor.getCorreo(), vendedor.getCiudad(), vendedor.getDepartamento(),
                vendedor.getTipoDocumento(), vendedor.getNroDocumento(), vendedor.getIdVendedor());
        modeloVendedor.crear(vendedor, listaVendedores);
        return true;
    }

    public Vendedor leer(int idVendedor, List<Vendedor> listaVendedores) {
        try {
            return modeloVendedor.leer(idVendedor, listaVendedores);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean actualizar(List<Vendedor> listaVendedores) {
        vendedor.actualizar(vendedor.getNombre(), vendedor.getDireccion(), vendedor.getTelefono(),
                vendedor.getCorreo(), vendedor.getCiudad(), vendedor.getDepartamento(),
                vendedor.getTipoDocumento(), vendedor.getNroDocumento(), vendedor.getIdVendedor());
        return modeloVendedor.actualizar(vendedor, listaVendedores);
    }

}
