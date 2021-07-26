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

    public ModelCliente() {
    }

    public boolean crear(Cliente cliente, ArrayList<Cliente> tablaClientes) {
        tablaClientes.add(cliente);
        return true;
    }

    public Cliente leer(int idCliente, ArrayList<Cliente> tablaClientes) {
        for (Cliente cliente : tablaClientes) {
            if (cliente.getIdCliente() == idCliente) {
                Cliente clienteEncontrado = new Cliente(cliente.getNombre(), cliente.getDireccion(),
                        cliente.getTelefono(), cliente.getCorreo(), cliente.getCiudad(),
                        cliente.getDepartamento(), cliente.getTipoDocumento(), cliente.getNroDocumento(),
                        cliente.getFechaNacimiento(), cliente.getIdCliente());
                return clienteEncontrado;
            }
        }
        return null;
    }

    public boolean actualizar(Cliente clienteActualizado, ArrayList<Cliente> tablaClientes) {
        for (Cliente cliente : tablaClientes) {
            if (cliente.getIdCliente() == clienteActualizado.getIdCliente()) {
                cliente.setNombre(clienteActualizado.getNombre());
                cliente.setDireccion(clienteActualizado.getDireccion());
                cliente.setCorreo(clienteActualizado.getCorreo());
                cliente.setCiudad(clienteActualizado.getCiudad());
                cliente.setDepartamento(clienteActualizado.getDepartamento());
                cliente.setFechaNacimiento(clienteActualizado.getFechaNacimiento());
                cliente.setNroDocumento(clienteActualizado.getNroDocumento());
                cliente.setTipoDocumento(clienteActualizado.getTipoDocumento());
                return true;
            }
        }
        return false;
    }
}
