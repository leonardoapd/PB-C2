/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.*;
import Model.ModelCliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leonardo Perdomo
 */
public class ControllerCliente {

    ModelCliente modeloCliente;

    public ControllerCliente() {
        modeloCliente = new ModelCliente();
    }

    public boolean crear(String nombre, String direccion, String telefono, String correo,
            String ciudad, String departamento, String tipoDocumento, int nroDocumento,
            String fechaNacimiento, int idCliente, ArrayList<Cliente> listaClientes) {

        Cliente cliente = new Cliente(nombre, direccion, telefono, correo,
                ciudad, departamento, tipoDocumento, nroDocumento,
                fechaNacimiento, idCliente);
        return modeloCliente.crear(cliente, listaClientes);
    }

    public Cliente leer(int idCliente, List<Cliente> listaClientes) {
        try {
            return modeloCliente.leer(idCliente, listaClientes);
        } catch (Exception e) {
            return null;
        }
    }
    
    public boolean actualizar(String nombre, String direccion, String telefono, String correo,
            String ciudad, String departamento, String tipoDocumento, int nroDocumento,
            String fechaNacimiento, int idCliente, List<Cliente> listaClientes) {
        Cliente cliente = new Cliente(nombre, direccion, telefono, correo,
                ciudad, departamento, tipoDocumento, nroDocumento,
                fechaNacimiento, idCliente);
        return modeloCliente.actualizar(cliente, listaClientes);
    }
}
