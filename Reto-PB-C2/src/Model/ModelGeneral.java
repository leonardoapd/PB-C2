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
public class ModelGeneral {

    private final DbData dbData;
    ArrayList<Producto> tablaProductos = new ArrayList<>();

    public ModelGeneral() {
        this.dbData = new DbData();
    }

    public String obtenerId(String nombreDeId, String nombreTablaDB) {
        try ( Connection conexion = DriverManager.getConnection(dbData.getUrl(),
                dbData.getUser(), dbData.getPassword())) {
            String query = "SELECT MAX(id" + nombreDeId + ") AS id FROM tb_" + nombreTablaDB + "";

            PreparedStatement statementPersona = conexion.prepareStatement(query);

            ResultSet resultado = statementPersona.executeQuery();

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

    public boolean agregarProducto(int idProducto, int idPedido) {
        try ( Connection conexion = DriverManager.getConnection(dbData.getUrl(),
                dbData.getUser(), dbData.getPassword())) {
            String query
                    = "INSERT INTO tb_pedido_producto (idPedido, idProducto) VALUES (?, ?)";

            PreparedStatement statementCliente = conexion.prepareStatement(query);

            statementCliente.setInt(1, idPedido);
            statementCliente.setInt(2, idProducto);

            int filasInsertadas = statementCliente.executeUpdate();
            conexion.close();
            return filasInsertadas > 0;
        } catch (SQLException e) {
            e.getMessage();
            System.out.println("Se jodio en el modelo");
        }
        return false;
    }

    public ArrayList<Producto> refrescarTabla(int idPedido) {
        try ( Connection conexion = DriverManager.getConnection(dbData.getUrl(),
                dbData.getUser(), dbData.getPassword())) {
            Producto producto = null;
            
            
            String query
                    = "SELECT p.nombre, p.unidadMedida FROM "
                    + "tb_productos as p INNER JOIN tb_pedido_producto as pp WHERE "
                    + "p.idProducto = pp.idProducto AND pp.idPedido = "+ idPedido;
                    

            PreparedStatement statementCliente = conexion.prepareStatement(query);
            

            ResultSet resultado = statementCliente.executeQuery();

            while (resultado.next()) {
                String nombre = resultado.getString(1);
                String unidadMedida = resultado.getString(2);
                producto = new Producto();
                producto.setNombre(nombre);
                producto.setUnidadMedida(unidadMedida);
                tablaProductos.add(producto);
            }

            conexion.close();
            return tablaProductos;
        } catch (SQLException e) {
            e.getMessage();
            System.out.println("Se jodio en el modelo");
        }
        return null;

    }

}
