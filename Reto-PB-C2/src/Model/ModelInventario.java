/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Classes.*;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Leonardo Perdomo
 */
public class ModelInventario {

    private final DbData dbData;
    Inventario inventario;
    ArrayList<Producto> productos = new ArrayList<>();

    public ModelInventario() {
        this.dbData = new DbData();
    }

    public boolean agregarProducto(Producto producto, int idInventario) throws SQLException {

        /*Se trata de conectar a la base de datos y si lo logra, se añaden los datos de
        los productos a la base de datos.
         */
        try ( Connection conexion = DriverManager.getConnection(dbData.getUrl(),
                dbData.getUser(), dbData.getPassword())) {
            String query
                    = "INSERT INTO tb_productos "
                    + "(nombre, descripcion, precio, cantidad, idProvedor) "
                    + "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement statementProducto = conexion.prepareStatement(query);

            statementProducto.setString(1, producto.getNombre());
            statementProducto.setString(2, producto.getDescripcion());
            statementProducto.setInt(3, producto.getPrecioUnitario());
            statementProducto.setInt(4, producto.getCantidadInventario());
            statementProducto.setInt(5, producto.getIdProveedor());

            int filasInsertadas = statementProducto.executeUpdate();

            return filasInsertadas > 0;
        } catch (SQLException e) {
            return false;
        }
    }
    
    //TODO
    public Producto buscar(int idProducto) {

        Producto producto = null;
        try ( Connection conexion = DriverManager.getConnection(dbData.getUrl(),
                dbData.getUser(), dbData.getPassword())) {
            String query = "SELECT * FROM tb_productos WHERE idProducto = ?";

            PreparedStatement statementProducto = conexion.prepareStatement(query);

            statementProducto.setInt(1, idProducto);

            ResultSet resultado = statementProducto.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt(1);
                String nombre = resultado.getString(2);
                String descripcion = resultado.getString(3);
                int precio = resultado.getInt(4);
                int cantidad = resultado.getInt(5);
                int idProveedor = resultado.getInt(6);
                producto = new Producto(nombre, descripcion, precio, cantidad,
                        id, idProveedor);
            }

            return producto;
        } catch (SQLException e) {
            System.out.println("Se frego en el modelo");
        }
        return null;
    }
    
    public boolean actualizar(Producto producto) {

        try ( Connection conexion = DriverManager.getConnection(dbData.getUrl(),
                dbData.getUser(), dbData.getPassword())) {
            String query
                    = "UPDATE tb_productos SET nombre = ? , descripcion = ?, precio = ?,"
                    + " cantidad = ?, idProvedor = ? WHERE idProducto = ?";

            PreparedStatement statementProducto = conexion.prepareStatement(query);

            statementProducto.setString(1, producto.getNombre());
            statementProducto.setString(2, producto.getDescripcion());
            statementProducto.setInt(3, producto.getPrecioUnitario());
            statementProducto.setInt(4, producto.getCantidadInventario());
            statementProducto.setInt(5, producto.getIdProveedor());
            statementProducto.setInt(6, producto.getIdProducto());
            
            int filasInsertadas = statementProducto.executeUpdate();

            return filasInsertadas > 0;
        } catch (SQLException e) {
            System.out.println("Se jodio en el modelo");
        }
        return false;
    }

    public ArrayList<Producto> refrescarTabla() {
        Producto producto = null;
        try ( Connection conexion = DriverManager.getConnection(dbData.getUrl(),
                dbData.getUser(), dbData.getPassword())) {
            String query = "SELECT * FROM tb_productos";

            PreparedStatement statementCliente = conexion.prepareStatement(query);

            ResultSet resultado = statementCliente.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt(1);
                String nombre = resultado.getString(2);
                String descripcion = resultado.getString(3);
                int precio = resultado.getInt(4);
                int cantidad = resultado.getInt(5);
                int idProveedor = resultado.getInt(6);
                

                producto = new Producto(nombre, descripcion, precio, cantidad,
                        id, idProveedor);
                productos.add(producto);
            }

            return productos;
        } catch (SQLException e) {
            System.out.println("Hubo un problema para resfrecar la tabla en el modelo");
        }
        return null;
    }
}
