/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Classes.Vendedor;
import java.util.*;

/**
 *
 * @author Leonardo Perdomo
 */
public class ModelVendedor {

    public ModelVendedor() {
    }

    public void crear(Vendedor vendedor, ArrayList<Vendedor> listaVendedores) {
        listaVendedores.add(vendedor);
    }

    public Vendedor leer(int idVendedor, ArrayList<Vendedor> listaVendedores) {
        for (Vendedor vendedor : listaVendedores) {
            if (vendedor.getIdVendedor() == idVendedor) {
                Vendedor vendedorLeido = new Vendedor(vendedor.getNombre(), vendedor.getDireccion(),
                        vendedor.getTelefono(), vendedor.getCorreo(), vendedor.getCiudad(), vendedor.getDepartamento(),
                        vendedor.getTipoDocumento(), vendedor.getNroDocumento(),
                        vendedor.getIdVendedor());
                return vendedorLeido;
            }
        }
        return null;
    }

    public boolean actualizar(Vendedor vendedorActualizado, ArrayList<Vendedor> listaVendedores) {
        for (Vendedor vendedor : listaVendedores) {
            if (vendedor.getIdVendedor() == vendedorActualizado.getIdVendedor()) {
                vendedor.setNombre(vendedorActualizado.getNombre());
                vendedor.setDireccion(vendedorActualizado.getDireccion());
                vendedor.setCorreo(vendedorActualizado.getCorreo());
                vendedor.setCiudad(vendedorActualizado.getCiudad());
                vendedor.setDepartamento(vendedorActualizado.getDepartamento());
                vendedor.setNroDocumento(vendedorActualizado.getNroDocumento());
                vendedor.setTipoDocumento(vendedorActualizado.getTipoDocumento());
                return true;
            }
        }
        return false;
    }
}
