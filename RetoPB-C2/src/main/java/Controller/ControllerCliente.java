/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.*;
import Model.ModelCliente;
import java.util.*;

/**
 *
 * @author Leonardo Perdomo
 */
public class ControllerCliente {

    private final ModelCliente modeloCliente;
    private ArrayList<Cliente> tablaClientes;
    private Cliente cliente;

    public ControllerCliente() {
        modeloCliente = new ModelCliente();
        tablaClientes = new ArrayList<>();
    }

    public boolean crear(String nombre, String direccion, String telefono, String correo,
            String ciudad, String departamento, String tipoDocumento, int nroDocumento,
            String fechaNacimiento, int idCliente) {
        cliente = new Cliente(nombre, direccion, telefono, correo,
                ciudad, departamento, tipoDocumento, nroDocumento,
                fechaNacimiento, idCliente);
        tablaClientes = modeloCliente.crear(cliente);
        return true;
    }

    public String[] buscar(int idCliente) {
        try {
            return modeloCliente.buscar(idCliente, tablaClientes);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean actualizar(String nombre, String direccion, String telefono, String correo,
            String ciudad, String departamento, String tipoDocumento, int nroDocumento,
            String fechaNacimiento, int idCliente) {
        cliente = new Cliente(nombre, direccion, telefono, correo,
                ciudad, departamento, tipoDocumento, nroDocumento,
                fechaNacimiento, idCliente);
        tablaClientes = modeloCliente.actualizar(cliente, this.tablaClientes);
        return true;
    }

    public String[][] refrescarTablaCliente() {
        int indice = tablaClientes.size();
        String[][] matrizCliente = new String[indice][10];
        int i = 0;
        for (Cliente clienteEncontrado : tablaClientes) {
            matrizCliente[i][0] = Integer.toString(clienteEncontrado.getIdCliente());
            matrizCliente[i][1] = clienteEncontrado.getNombre();
            matrizCliente[i][2] = clienteEncontrado.getDireccion();
            matrizCliente[i][3] = clienteEncontrado.getTelefono();
            matrizCliente[i][4] = clienteEncontrado.getCorreo();
            matrizCliente[i][5] = clienteEncontrado.getCiudad();
            matrizCliente[i][6] = clienteEncontrado.getDepartamento();
            matrizCliente[i][7] = clienteEncontrado.getTipoDocumento();
            matrizCliente[i][8] = Integer.toString(clienteEncontrado.getNroDocumento());
            matrizCliente[i][9] = clienteEncontrado.getFechaNacimiento();
            i++;
        }
        return matrizCliente;
    }
}
