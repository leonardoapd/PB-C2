/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Classes.*;
import java.util.List;

/**
 *
 * @author Leonardo Perdomo
 */
public class ModelCliente {

    public ModelCliente() {
    }

    public boolean crear(Cliente cliente, List<Cliente> listaClientes) {
        listaClientes.add(cliente);
        return true;
    }

    public Cliente leer(int idCliente, List<Cliente> listaClientes) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getIdCliente() == idCliente) {
                Cliente clienteEncontrado = new Cliente(cliente.getNombre(), cliente.getDireccion(),
                        cliente.getTelefono(), cliente.getCorreo(), cliente.getCiudad(),
                        cliente.getDepartamento(), cliente.getTipoDocumento(), cliente.getNroDocumento(),
                        cliente.getFechaNacimiento(), cliente.getIdCliente(), cliente.getCantidadCompras());
                return clienteEncontrado;
            }
        }
        return null;
    }
}
