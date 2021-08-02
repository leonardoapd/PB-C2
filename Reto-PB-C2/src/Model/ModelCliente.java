/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Classes.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
import java.sql.*;

/**
 *
 * @author Leonardo Perdomo
 */
public class ModelCliente {

    private final DbData dbData;
    ArrayList<Cliente> tablaClientes = new ArrayList<>();

    public ModelCliente() {
        this.dbData = new DbData();
    }

    public boolean crear(Cliente cliente) {

        /*Se trata de conectar a la base de datos y si lo logra, se añaden los datos de
        los productos a la base de datos.
         */
        try ( Connection conexion = DriverManager.getConnection(dbData.getUrl(),
                dbData.getUser(), dbData.getPassword())) {
            String query
                    = "INSERT INTO tb_clientes (nombre, direccion, telefono,"
                    + " correo, ciudad, departamento, tipoDocumento, "
                    + "nroDocumento, fechaNacimiento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement statementCliente = conexion.prepareStatement(query);

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
            conexion.close();
            return filasInsertadas > 0;
        } catch (SQLException e) {
            System.out.println("Se jodio en el modelo");
        }
        return false;
    }

    public Cliente buscar(int idCliente) {

        Cliente cliente = null;
        try ( Connection conexion = DriverManager.getConnection(dbData.getUrl(),
                dbData.getUser(), dbData.getPassword())) {
            String query = "SELECT * FROM tb_clientes WHERE idCliente = ?";

            PreparedStatement statementCliente = conexion.prepareStatement(query);

            statementCliente.setInt(1, idCliente);

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
            }
            conexion.close();
            return cliente;
        } catch (SQLException e) {
            System.out.println("Se frego en el modelo");
        }
        return null;
    }

    public boolean actualizar(Cliente cliente) {

        try ( Connection conexion = DriverManager.getConnection(dbData.getUrl(),
                dbData.getUser(), dbData.getPassword())) {
            String query
                    = "UPDATE tb_clientes SET nombre = ? , direccion = ?, telefono = ?,"
                    + " correo = ?, ciudad = ?, departamento = ?, tipoDocumento = ?, nroDocumento = ?,"
                    + " fechaNacimiento = ? WHERE idCliente= ?";

            PreparedStatement statementCliente = conexion.prepareStatement(query);

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
            conexion.close();
            return filasInsertadas > 0;
        } catch (SQLException e) {
            System.out.println("Se jodio en el modelo");
        }
        return false;
    }

    public ArrayList<Cliente> refrescarTabla() {
        Cliente cliente = null;
        try ( Connection conexion = DriverManager.getConnection(dbData.getUrl(),
                dbData.getUser(), dbData.getPassword())) {
            String query = "SELECT * FROM tb_clientes";

            PreparedStatement statementCliente = conexion.prepareStatement(query);

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
            conexion.close();
            return tablaClientes;
        } catch (SQLException e) {
            System.out.println("Hubo un problema para resfrecar la tabla en el modelo");
        }
        return null;
    }
}
