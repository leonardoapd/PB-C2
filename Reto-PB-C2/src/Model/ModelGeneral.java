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
        try {
            dbData.connectBD();
            String query = "SELECT MAX(id" + nombreDeId + ") AS id FROM tb_" + nombreTablaDB + "";

            PreparedStatement statementPersona = dbData.getConnect().prepareStatement(query);

            ResultSet resultado = statementPersona.executeQuery();

            int id = 0;
            while (resultado.next()) {
                id = resultado.getInt(1);
            }
            dbData.disconnectBD();
            return Integer.toString(id + 1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public boolean agregarProducto(int idProducto, int idPedido) {
        try {
            dbData.connectBD();
            String query
                    = "INSERT INTO tb_pedido_producto (idPedido, idProducto) VALUES (?, ?)";

            PreparedStatement statementProducto = dbData.getConnect().prepareStatement(query);

            statementProducto.setInt(1, idPedido);
            statementProducto.setInt(2, idProducto);

            int filasInsertadas = statementProducto.executeUpdate();
            
            dbData.disconnectBD();
            
            return filasInsertadas > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public ArrayList<Producto> refrescarTabla(int idPedido) {
        try {
            dbData.connectBD();
            Producto producto = null;

            //Sentencia con INNER JOIN para buscar la interseccion de ids en diferentes tablas
            //de la base de datos buscandola con el id del pedido.
            String query
                    = "SELECT p.idProducto, p.nombre, p.unidadMedida FROM "
                    + "tb_productos as p INNER JOIN tb_pedido_producto as pp WHERE "
                    + "p.idProducto = pp.idProducto AND pp.idPedido = " + idPedido;

            PreparedStatement statementProducto = dbData.getConnect().prepareStatement(query);

            ResultSet resultado = statementProducto.executeQuery();

            while (resultado.next()) {
                int idProducto = resultado.getInt(1);
                String nombre = resultado.getString(2);
                String unidadMedida = resultado.getString(3);
                producto = new Producto();
                producto.setIdProducto(idProducto);
                producto.setNombre(nombre);
                producto.setUnidadMedida(unidadMedida);
                tablaProductos.add(producto);
            }

            dbData.disconnectBD();
            return tablaProductos;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

    public String buscarCliente(int idCliente) {
        try {
            dbData.connectBD();
            String query =
                    "SELECT nombre FROM tb_clientes WHERE idCliente = " + idCliente;
            
            PreparedStatement comando = dbData.getConnect().prepareStatement(query);

            ResultSet resultado = comando.executeQuery();
            
            String nombre = "";
            while (resultado.next()) {
                nombre = resultado.getString(1);
            }
            dbData.disconnectBD();
            
            return nombre;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
