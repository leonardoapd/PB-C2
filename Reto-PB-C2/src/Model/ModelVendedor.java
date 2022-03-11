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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Leonardo Perdomo
 */
public class ModelVendedor {

    private final BaseDeDatos dbData;
    ArrayList<Vendedor> tablaVendedores = new ArrayList<>();

    public ModelVendedor() {
        this.dbData = new BaseDeDatos();
    }

    public boolean crear(Vendedor vendedor) {

        /*Se trata de conectar a la base de datos y si lo logra, se añaden los datos de
        los productos a la base de datos.
         */
        try ( Connection conexion = DriverManager.getConnection(dbData.getUrl(),
                dbData.getUser(), dbData.getPassword())) {
            String query
                    = "INSERT INTO tb_vendedores (nombre, direccion, telefono, correo, ciudad, departamento, tipoDocumento, nroDocumento) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement statementVendedor = conexion.prepareStatement(query);

            statementVendedor.setString(1, vendedor.getNombre());
            statementVendedor.setString(2, vendedor.getDireccion());
            statementVendedor.setString(3, vendedor.getTelefono());
            statementVendedor.setString(4, vendedor.getCorreo());
            statementVendedor.setString(5, vendedor.getCiudad());
            statementVendedor.setString(6, vendedor.getDepartamento());
            statementVendedor.setString(7, vendedor.getTipoDocumento());
            statementVendedor.setInt(8, vendedor.getNroDocumento());

            int filasInsertadas = statementVendedor.executeUpdate();
            conexion.close();
            return filasInsertadas > 0;
        } catch (SQLException e) {
            System.out.println("Se jodio en el modelo");
        }
        return false;
    }

    public Vendedor buscar(int idVendedor) {

        Vendedor vendedor = null;
        try ( Connection conexion = DriverManager.getConnection(dbData.getUrl(),
                dbData.getUser(), dbData.getPassword())) {
            String query = "SELECT * FROM tb_vendedores WHERE idVendedor = ?";

            PreparedStatement statementVendedor = conexion.prepareStatement(query);

            statementVendedor.setInt(1, idVendedor);

            ResultSet resultado = statementVendedor.executeQuery();

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
                vendedor = new Vendedor(nombre, direccion, telefono, correo, ciudad,
                        departamento, tipoDocumento, nroDocumento, id);
            }
            conexion.close();
            return vendedor;
        } catch (SQLException e) {
            System.out.println("Se frego en el modelo");
        }
        return null;
    }

    public boolean actualizar(Vendedor vendedor) {

        try ( Connection conexion = DriverManager.getConnection(dbData.getUrl(),
                dbData.getUser(), dbData.getPassword())) {
            String query
                    = "UPDATE tb_vendedores SET nombre = ? , direccion = ?, telefono = ?,"
                    + " correo = ?, ciudad = ?, departamento = ?, tipoDocumento = ?, nroDocumento = ?"
                    + "  WHERE idVendedor = ?";

            PreparedStatement statementVendedor = conexion.prepareStatement(query);

            statementVendedor.setString(1, vendedor.getNombre());
            statementVendedor.setString(2, vendedor.getDireccion());
            statementVendedor.setString(3, vendedor.getTelefono());
            statementVendedor.setString(4, vendedor.getCorreo());
            statementVendedor.setString(5, vendedor.getCiudad());
            statementVendedor.setString(6, vendedor.getDepartamento());
            statementVendedor.setString(7, vendedor.getTipoDocumento());
            statementVendedor.setInt(8, vendedor.getNroDocumento());
            statementVendedor.setInt(9, vendedor.getIdVendedor());

            int filasInsertadas = statementVendedor.executeUpdate();
            conexion.close();
            return filasInsertadas > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Se jodio en el modelo, en actualizar");
        }
        return false;
    }

    public ArrayList<Vendedor> refrescarTabla() {
        Vendedor vendedor = null;
        try ( Connection conexion = DriverManager.getConnection(dbData.getUrl(),
                dbData.getUser(), dbData.getPassword())) {
            String query = "SELECT * FROM tb_vendedores";

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

                vendedor = new Vendedor(nombre, direccion, telefono, correo, ciudad,
                        departamento, tipoDocumento, nroDocumento, id);
                tablaVendedores.add(vendedor);
            }
            conexion.close();
            return tablaVendedores;
        } catch (SQLException e) {
            System.out.println("Hubo un problema para resfrecar la tabla en el modelo");
        }
        return null;
    }
}
