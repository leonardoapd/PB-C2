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
public class ModelProveedor {

    private final DbData dbData;
    ArrayList<Proveedor> tablaProveedores = new ArrayList<>();

    public ModelProveedor() {
        this.dbData = new DbData();
    }
 
    public boolean crear(Proveedor proveedor) {

        /*Se trata de conectar a la base de datos y si lo logra, se añaden los datos de
        los productos a la base de datos.
         */
        try ( Connection conexion = DriverManager.getConnection(dbData.getUrl(),
                dbData.getUser(), dbData.getPassword())) {
            String query
                    = "INSERT INTO tb_proveedores (nombre, direccion, telefono,"
                    + " correo, ciudad, departamento, tipoDocumento, "
                    + "nroDocumento) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement statementProveedor = conexion.prepareStatement(query);

            statementProveedor.setString(1, proveedor.getNombre());
            statementProveedor.setString(2, proveedor.getDireccion());
            statementProveedor.setString(3, proveedor.getTelefono());
            statementProveedor.setString(4, proveedor.getCorreo());
            statementProveedor.setString(5, proveedor.getCiudad());
            statementProveedor.setString(6, proveedor.getDepartamento());
            statementProveedor.setString(7, proveedor.getTipoDocumento());
            statementProveedor.setInt(8, proveedor.getNroDocumento());

            int filasInsertadas = statementProveedor.executeUpdate();

            return filasInsertadas > 0;
        } catch (SQLException e) {
            System.out.println("Se jodio en el modelo");
        }
        return false;
    }

    public Proveedor buscar(int idProveedor) {

        Proveedor proveedor = null;
        try ( Connection conexion = DriverManager.getConnection(dbData.getUrl(),
                dbData.getUser(), dbData.getPassword())) {
            String query = "SELECT * FROM tb_proveedores WHERE idProveedor = ?";

            PreparedStatement statementProveedor = conexion.prepareStatement(query);

            statementProveedor.setInt(1, idProveedor);

            ResultSet resultado = statementProveedor.executeQuery();

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
                proveedor = new Proveedor(nombre, direccion, telefono, correo, ciudad,
                        departamento, tipoDocumento, nroDocumento, id);
            }

            return proveedor;
        } catch (SQLException e) {
            System.out.println("Se frego en el modelo");
        }
        return null;
    }

    public boolean actualizar(Proveedor proveedor) {

        try ( Connection conexion = DriverManager.getConnection(dbData.getUrl(),
                dbData.getUser(), dbData.getPassword())) {
            String query
                    = "UPDATE tb_proveedores SET nombre = ? , direccion = ?, telefono = ?,"
                    + " correo = ?, ciudad = ?, departamento = ?, tipoDocumento = ?, nroDocumento = ?,"
                    + "  WHERE idProveedor= ?";

            PreparedStatement statementProveedor = conexion.prepareStatement(query);

            statementProveedor.setString(1, proveedor.getNombre());
            statementProveedor.setString(2, proveedor.getDireccion());
            statementProveedor.setString(3, proveedor.getTelefono());
            statementProveedor.setString(4, proveedor.getCorreo());
            statementProveedor.setString(5, proveedor.getCiudad());
            statementProveedor.setString(6, proveedor.getDepartamento());
            statementProveedor.setString(7, proveedor.getTipoDocumento());
            statementProveedor.setInt(8, proveedor.getNroDocumento());
            statementProveedor.setInt(10, proveedor.getIdProveedor());

            int filasInsertadas = statementProveedor.executeUpdate();

            return filasInsertadas > 0;
        } catch (SQLException e) {
            System.out.println("Se jodio en el modelo");
        }
        return false;
    }
    
    public ArrayList<Proveedor> refrescarTabla() {
        Proveedor proveedor = null;
        try ( Connection conexion = DriverManager.getConnection(dbData.getUrl(),
                dbData.getUser(), dbData.getPassword())) {
            String query = "SELECT * FROM tb_proveedores";

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

                proveedor = new Proveedor(nombre, direccion, telefono, correo, ciudad,
                        departamento, tipoDocumento, nroDocumento, id);
                tablaProveedores.add(proveedor);
            }

            return tablaProveedores;
        } catch (SQLException e) {
            System.out.println("Hubo un problema para resfrecar la tabla en el modelo");
        }
        return null;
    }
}
