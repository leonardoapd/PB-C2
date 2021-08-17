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

    private final BaseDeDatos dbData;
    Inventario inventario;
    ArrayList<Producto> productos = new ArrayList<>();
    ArrayList<String> listaDeProveedores = new ArrayList<>();

    public ModelInventario() {
        this.dbData = new BaseDeDatos();
    }

    public boolean agregarProducto(Producto producto, int idInventario) throws SQLException {

        /*Se trata de conectar a la base de datos y si lo logra, se añaden los datos de
        los productos a la base de datos.
         */
        try (Connection conexion = DriverManager.getConnection(dbData.getUrl(),
                dbData.getUser(), dbData.getPassword())) {
            String query
                    = "INSERT INTO tb_productos "
                    + "(nombre, descripcion, unidadMedida) "
                    + "VALUES (?, ?, ?)";

            PreparedStatement statementProducto = conexion.prepareStatement(query);

            statementProducto.setString(1, producto.getNombre());
            statementProducto.setString(2, producto.getDescripcion());
            statementProducto.setString(3, producto.getUnidadMedida());

            int filasInsertadas = statementProducto.executeUpdate();
            conexion.close();
            return filasInsertadas > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    //TODO
    public Producto buscar(int idProducto) {

        Producto producto = null;
        try (Connection conexion = DriverManager.getConnection(dbData.getUrl(),
                dbData.getUser(), dbData.getPassword())) {
            String query = "SELECT * FROM tb_productos WHERE idProducto = ?";

            PreparedStatement statementProducto = conexion.prepareStatement(query);

            statementProducto.setInt(1, idProducto);

            ResultSet resultado = statementProducto.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt(1);
                String nombre = resultado.getString(2);
                String descripcion = resultado.getString(3);
                String unidadMedida = resultado.getString(4);
                producto = new Producto();
                producto.setNombre(nombre);
                producto.setDescripcion(descripcion);
                producto.setUnidadMedida(unidadMedida);
                producto.setIdProducto(id);
            }
            conexion.close();
            return producto;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Se frego en el modelo");
        }
        return null;
    }

    public boolean actualizar(Producto producto, double total) {

        try (Connection conexion = DriverManager.getConnection(dbData.getUrl(),
                dbData.getUser(), dbData.getPassword())) {
            String query = "";
            PreparedStatement statementProducto = null;
            if (producto.getDescripcion().equals("")) {
                query = "SELECT total, cantidad, precioPromedio FROM tb_productos "
                        + "WHERE idProducto = " + producto.getIdProducto();

                statementProducto = conexion.prepareStatement(query);

                ResultSet resultado = statementProducto.executeQuery();
                
                int cantidad = producto.getCantidadInventario();
                double precioPromedio = 0;
                while (resultado.next()) {
                total += resultado.getInt(1);
                cantidad += resultado.getInt(2);
                }
                
                precioPromedio = total/cantidad;
                
                query
                        = "UPDATE tb_productos SET "
                        + "precio = ?, cantidad = ?, idProveedor = ?, total = " + total
                        + ", precioPromedio = " + precioPromedio + " WHERE idProducto = ?";

                statementProducto = conexion.prepareStatement(query);
                statementProducto.setInt(1, producto.getPrecioUnitario());
                statementProducto.setInt(2, cantidad);
                statementProducto.setInt(3, producto.getIdProveedor());
                statementProducto.setInt(4, producto.getIdProducto());
            } else if (producto.getPrecioUnitario() == 0) {
                query
                        = "UPDATE tb_productos SET nombre = ? , descripcion = ?, unidadMedida = ? "
                        + "WHERE idProducto = ?";

                statementProducto = conexion.prepareStatement(query);

                statementProducto.setString(1, producto.getNombre());
                statementProducto.setString(2, producto.getDescripcion());
                statementProducto.setString(3, producto.getUnidadMedida());
                statementProducto.setInt(4, producto.getIdProducto());
            }

            int filasInsertadas = statementProducto.executeUpdate();
            conexion.close();
            return filasInsertadas > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Se jodio en el modelo");
        }
        return false;
    }

    public ArrayList<Producto> refrescarTabla() {
        Producto producto = null;
        try (Connection conexion = DriverManager.getConnection(dbData.getUrl(),
                dbData.getUser(), dbData.getPassword())) {
            String query = "SELECT * FROM tb_productos";

            PreparedStatement statementCliente = conexion.prepareStatement(query);

            ResultSet resultado = statementCliente.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt(1);
                String nombre = resultado.getString(2);
                String descripcion = resultado.getString(3);
                String unidadMedida = resultado.getString(4);
                int precio = resultado.getInt(5);
                int cantidad = resultado.getInt(6);
                int idProveedor = resultado.getInt(7);
                int precioPromedio = resultado.getInt(9);

                producto = new Producto(nombre, descripcion, unidadMedida, precioPromedio, cantidad,
                        id, idProveedor);
                productos.add(producto);
            }
            conexion.close();
            return productos;
        } catch (SQLException e) {
            System.out.println("Hubo un problema para resfrecar la tabla en el modelo");
        }
        return null;
    }

    public String obtenerId() {
        try (Connection conexion = DriverManager.getConnection(dbData.getUrl(),
                dbData.getUser(), dbData.getPassword())) {
            String query = "SELECT MAX(idProducto) AS id FROM tb_productos";

            PreparedStatement statementProducto = conexion.prepareStatement(query);

            ResultSet resultado = statementProducto.executeQuery();

            int id = 0;
            while (resultado.next()) {
                id = resultado.getInt(1);
            }
            conexion.close();
            return Integer.toString(id + 1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Se frego en el modelo");
        }
        return null;
    }

    public ArrayList<Producto> refrescarTablaProducto() {
        Producto producto = null;
        try (Connection conexion = DriverManager.getConnection(dbData.getUrl(),
                dbData.getUser(), dbData.getPassword())) {
            String query = "SELECT idProducto, nombre, unidadMedida, descripcion FROM tb_productos";

            PreparedStatement statementProducto = conexion.prepareStatement(query);

            ResultSet resultado = statementProducto.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt(1);
                String nombre = resultado.getString(2);
                String unidadMedida = resultado.getString(3);
                String descripcion = resultado.getString(4);
                producto = new Producto();
                producto.setNombre(nombre);
                producto.setDescripcion(descripcion);
                producto.setUnidadMedida(unidadMedida);
                producto.setIdProducto(id);
                productos.add(producto);
            }
            conexion.close();
            return productos;
        } catch (SQLException e) {
            System.out.println("Hubo un problema para resfrecar la tabla en el modelo");
        }
        return null;
    }

    public ArrayList<String> obtenerListaProveedores() {
        try (Connection conexion = DriverManager.getConnection(dbData.getUrl(),
                dbData.getUser(), dbData.getPassword())) {
            String query = "SELECT nombre FROM tb_proveedores";

            PreparedStatement statementCliente = conexion.prepareStatement(query);

            ResultSet resultado = statementCliente.executeQuery();
            listaDeProveedores.clear();
            while (resultado.next()) {
                String nombre = resultado.getString(1);
                listaDeProveedores.add(nombre);
            }
            conexion.close();
            return listaDeProveedores;
        } catch (SQLException e) {
            System.out.println("Hubo un problema para resfrecar la tabla en el modelo");
        }
        return null;
    }

    public int obtenerNombreProveedor(String seleccionado) {
        try (Connection conexion = DriverManager.getConnection(dbData.getUrl(),
                dbData.getUser(), dbData.getPassword())) {
            String query = "SELECT idProveedor FROM tb_proveedores WHERE nombre = ?";

            PreparedStatement statementNombreP = conexion.prepareStatement(query);

            statementNombreP.setString(1, seleccionado);

            ResultSet resultado = statementNombreP.executeQuery();
            int idProveedor = 0;
            while (resultado.next()) {
                idProveedor = resultado.getInt(1);
            }
            conexion.close();
            return idProveedor;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Hubo un problema para resfrecar la tabla en el modelo");
        }
        return 0;
    }
}
