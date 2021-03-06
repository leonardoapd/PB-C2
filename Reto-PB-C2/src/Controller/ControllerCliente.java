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
public class ControllerCliente {

    private final ModelCliente modeloCliente;
    private final ModelGeneral modeloGeneral;
    private Cliente cliente;

    public ControllerCliente() {
        modeloCliente = new ModelCliente();
        modeloGeneral = new ModelGeneral();
    }

    public boolean crear(String nombre, String direccion, String telefono, String correo,
            String ciudad, String departamento, String tipoDocumento, int nroDocumento,
            String fechaNacimiento, int idCliente) {
        cliente = new Cliente(nombre, direccion, telefono, correo,
                ciudad, departamento, tipoDocumento, nroDocumento,
                fechaNacimiento, idCliente);
        return modeloCliente.crear(cliente);
    }

    public String[] buscar(int idCliente) {
        String[] matrizCliente = new String[10];
        try {
            Cliente clienteEncontrado = modeloCliente.buscar(idCliente);
            matrizCliente[0] = Integer.toString(clienteEncontrado.getIdCliente());
            matrizCliente[1] = clienteEncontrado.getNombre();
            matrizCliente[2] = clienteEncontrado.getDireccion();
            matrizCliente[3] = clienteEncontrado.getTelefono();
            matrizCliente[4] = clienteEncontrado.getCorreo();
            matrizCliente[5] = clienteEncontrado.getCiudad();
            matrizCliente[6] = clienteEncontrado.getDepartamento();
            matrizCliente[7] = clienteEncontrado.getTipoDocumento();
            matrizCliente[8] = Integer.toString(clienteEncontrado.getNroDocumento());
            matrizCliente[9] = clienteEncontrado.getFechaNacimiento();
            return matrizCliente;
        } catch (Exception e) {
            System.out.println("Hubo un problema para buscar el cliente en el controlador");
        }
        return null;
    }

    public boolean actualizar(String nombre, String direccion, String telefono, String correo,
            String ciudad, String departamento, String tipoDocumento, int nroDocumento,
            String fechaNacimiento, int idCliente) {
        cliente = new Cliente(nombre, direccion, telefono, correo,
                ciudad, departamento, tipoDocumento, nroDocumento,
                fechaNacimiento, idCliente);
        return modeloCliente.actualizar(cliente);
    }

    public String[][] refrescarTablaCliente() {
        
        ArrayList<Cliente> tabla = modeloCliente.refrescarTabla();
        int indice = tabla.size();
        String[][] matrizCliente = new String[indice][10];
        int i = 0;
        for (Cliente clienteEncontrado : tabla) {
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
        tabla.clear();
        return matrizCliente;
    }
    
    public String obtenerId(String persona, String nombreTablaBD) {
        return modeloGeneral.obtenerId(persona, nombreTablaBD);
    }
}
