/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Classes.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leonardo Perdomo
 */
public class ModelCliente {

    public ModelCliente() {
    }

    public boolean crear(Cliente cliente, ArrayList<Cliente> listaClientes) {
        listaClientes.add(cliente);
        return true;
    }

    public Cliente leer(int idCliente, List<Cliente> listaClientes) {
        for (Cliente cliente : listaClientes) {
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

    public boolean actualizar(Cliente clienteActualizado, List<Cliente> listaClientes) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getIdCliente() == clienteActualizado.getIdCliente()) {
                cliente.setNombre(clienteActualizado.getNombre());
                cliente.setDireccion(clienteActualizado.getDireccion());
                cliente.setCorreo(clienteActualizado.getCorreo());
                cliente.setCiudad(clienteActualizado.getCiudad());
                cliente.setDepartamento(clienteActualizado.getDepartamento());
                cliente.setFechaNacimiento(clienteActualizado.getFechaNacimiento());
                cliente.setNroDocumento(clienteActualizado.getNroDocumento());
                
                return true;
            }
        }
        return false;
    }
}
