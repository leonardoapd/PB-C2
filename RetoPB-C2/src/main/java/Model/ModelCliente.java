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
public class ModelCliente {

    ArrayList<Cliente> tablaClientes = new ArrayList<>();

    public ModelCliente() {
    }

    public ArrayList<Cliente> crear(Cliente cliente) {
        tablaClientes.add(cliente);
        return tablaClientes;
    }

    public String[] buscar(int idCliente, ArrayList<Cliente> tablaClientes) {

        String[] matrizCliente = new String[10];

        for (Cliente clienteEncontrado : tablaClientes) {
            if (clienteEncontrado.getIdCliente() == idCliente) {
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
            }
        }
        return matrizCliente;
    }

    public ArrayList<Cliente> actualizar(Cliente clienteActualizado, ArrayList<Cliente> tablaClientes) {
        for (Cliente cliente : tablaClientes) {
                cliente.setIdCliente(clienteActualizado.getIdCliente()); 
                cliente.setNombre(clienteActualizado.getNombre());
                cliente.setDireccion(clienteActualizado.getDireccion());
                cliente.setCorreo(clienteActualizado.getCorreo());
                cliente.setCiudad(clienteActualizado.getCiudad());
                cliente.setDepartamento(clienteActualizado.getDepartamento());
                cliente.setFechaNacimiento(clienteActualizado.getFechaNacimiento());
                cliente.setNroDocumento(clienteActualizado.getNroDocumento());
                cliente.setTipoDocumento(clienteActualizado.getTipoDocumento());
                return tablaClientes;
        }
        return null;
    }
}
