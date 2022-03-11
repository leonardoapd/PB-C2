/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Classes.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
import java.sql.*;

/**
 *
 * @author Leonardo Perdomo
 */
public class ModelCliente {

    private final BaseDeDatos dbData;
    ArrayList<Cliente> tablaClientes = new ArrayList<>();

    public ModelCliente() {
        this.dbData = new BaseDeDatos();
    }

    public boolean crear(Cliente cliente) {

        /*Se trata de conectar a la base de datos y si lo logra, se añaden los datos de
        los productos a la base de datos.
         */
        try {
            dbData.connectBD();
            
            String query
                    = "INSERT INTO tb_clientes (nombre, direccion, telefono,"
                    + " correo, ciudad, departamento, tipoDocumento, "
                    + "nroDocumento, fechaNacimiento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement statementCliente = dbData.getConnect().prepareStatement(query);

            statementCliente.setString(1, cliente.getNombre());
            statementCliente.setString(2, cliente.getDireccion());
            statementCliente.setString(3, cliente.getTelefono());
            statementCliente.setString(4, cliente.getCorreo());
            statementCliente.setString(5, cliente.getCiudad());
            statementCliente.setString(6, cliente.getDepartamento());
            statementCliente.setString(7, cliente.getTipoDocumento());
            statementCliente.setInt(8, cliente.getNroDocumento());
            statementCliente.setString(9, cliente.getFechaNacimiento());

            int filasInsertadas = statementCliente.executeUpdate();
            
            dbData.disconnectBD();
            
            return filasInsertadas > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public Cliente buscar(int idCliente) {
        
        // Se inicializa un objeto de la clase Cliente que es el que se retornará
        Cliente cliente = null;
        try {
            /**
             * Se realiza la conexion a la base de datos con ayuda de la clase
             * DbData.java
             */
            dbData.connectBD();
            // Se establece la sentencia que se inyectará a la BD para buscar los datos
            String query = "SELECT * FROM tb_clientes WHERE idCliente = ?";

            // Se prepara la sentencia SQL para su inyección
            PreparedStatement statementCliente = dbData.getConnect().prepareStatement(query);
            
            // Se añaden (set) los parametros para reemplazar aquellos con ? en la sentencia.
            statementCliente.setInt(1, idCliente);

            // Se ejecuta la sentencia SQL
            ResultSet resultado = statementCliente.executeQuery();

            /**
             * Se capturan los resultados de la consulta por medio de un while y se almacenan 
             * en variables para luego crear el objeto a devolver.
             */
            while (resultado.next()) {
                int id = resultado.getInt(1);
                String nombre = resultado.getString(2);
                String direccion = resultado.getString(3);
                String telefono = resultado.getString(4);
                String correo = resultado.getString(5);
                String ciudad = resultado.getString(6);
                String departamento = resultado.getString(7);
                String tipoDocumento = resultado.getString(8);
                int nroDocumento = resultado.getInt(9);
                String fechaNacimiento = resultado.getString(10);
                // Se crea un objeto con los parametros adquiridos de la BD
                cliente = new Cliente(nombre, direccion, telefono, correo, ciudad,
                        departamento, tipoDocumento, nroDocumento, fechaNacimiento, id);
            }
            /**
             * Es necesario realizar la desconexion de la base de datos despues
             * de cada consulta, ya que puede generarse una acumulación
             * innecesaria del uso de memoria.
             */
            dbData.disconnectBD();
            // Se retorna un objeto de la clse cliente
            return cliente;
        } catch (SQLException e) {
            //Si se genera una excepción, se obtiene su mensaje y se muestra por consola.
            System.out.println(e.getMessage());
        }
        return null;
    }

    public boolean actualizar(Cliente cliente) {

        try {
            dbData.connectBD();
            String query
                    = "UPDATE tb_clientes SET nombre = ? , direccion = ?, telefono = ?,"
                    + " correo = ?, ciudad = ?, departamento = ?, tipoDocumento = ?, nroDocumento = ?,"
                    + " fechaNacimiento = ? WHERE idCliente= ?";

            PreparedStatement statementCliente = dbData.getConnect().prepareStatement(query);

            statementCliente.setString(1, cliente.getNombre());
            statementCliente.setString(2, cliente.getDireccion());
            statementCliente.setString(3, cliente.getTelefono());
            statementCliente.setString(4, cliente.getCorreo());
            statementCliente.setString(5, cliente.getCiudad());
            statementCliente.setString(6, cliente.getDepartamento());
            statementCliente.setString(7, cliente.getTipoDocumento());
            statementCliente.setInt(8, cliente.getNroDocumento());
            statementCliente.setString(9, cliente.getFechaNacimiento());
            statementCliente.setInt(10, cliente.getIdCliente());

            int filasInsertadas = statementCliente.executeUpdate();

            dbData.disconnectBD();
            return filasInsertadas > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public ArrayList<Cliente> refrescarTabla() {
        Cliente cliente = null;
        try {
            dbData.connectBD();
            String query = "SELECT * FROM tb_clientes";

            PreparedStatement statementCliente = dbData.getConnect().prepareStatement(query);

            ResultSet resultado = statementCliente.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt(1);
                String nombre = resultado.getString(2);
                String direccion = resultado.getString(3);
                String telefono = resultado.getString(4);
                String correo = resultado.getString(5);
                String ciudad = resultado.getString(6);
                String departamento = resultado.getString(7);
                String tipoDocumento = resultado.getString(8);
                int nroDocumento = resultado.getInt(9);
                String fechaNacimiento = resultado.getString(10);

                cliente = new Cliente(nombre, direccion, telefono, correo, ciudad,
                        departamento, tipoDocumento, nroDocumento, fechaNacimiento, id);
                tablaClientes.add(cliente);
            }
            dbData.disconnectBD();
            return tablaClientes;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
