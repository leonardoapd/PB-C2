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
    ArrayList<String[]> informacionColumnas;
    ArrayList<ArrayList<String>> informacionFilas = new ArrayList<>();

    public ModelGeneral() {
        this.informacionColumnas = new ArrayList<>();
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
            String query
                    = "SELECT nombre FROM tb_clientes WHERE idCliente = " + idCliente;

            PreparedStatement comando = dbData.getConnect().prepareStatement(query);

            ResultSet resultado = comando.executeQuery();

            String nombre = "";
            while (resultado.next()) {
                nombre = resultado.getString(1);
            }
            dbData.disconnectBD();

            return nombre;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void crearPedido(String[][] informacionDeProductos, int idPedido, int idCliente,
            int idVendedor, String estadoPedido) {
        try {
            dbData.connectBD();
            String query
                    = "INSERT INTO tb_pedidos (idCliente, idVendedor, estadoPedido) VALUES (?, ?, ?)";

            PreparedStatement comando = dbData.getConnect().prepareStatement(query);

            comando.setInt(1, idCliente);
            comando.setInt(2, idVendedor);
            comando.setString(3, estadoPedido);

            int filasInsertadas = comando.executeUpdate();

            query = "INSERT INTO tb_pedido_producto (idPedido, idProducto, cantidad, precioDeVenta, totalDeVenta)"
                    + " VALUES (?, ?, ?, ?, ?)";

            comando = dbData.getConnect().prepareStatement(query);

            for (String[] informacionDeProducto : informacionDeProductos) {
                comando.setInt(1, idPedido);
                comando.setInt(2, Integer.parseInt(informacionDeProducto[0]));
                comando.setInt(3, Integer.parseInt(informacionDeProducto[3]));
                comando.setInt(4, Integer.parseInt(informacionDeProducto[4]));
                comando.setInt(5, Integer.parseInt(informacionDeProducto[5]));
                filasInsertadas = comando.executeUpdate();
            }

            dbData.disconnectBD();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public String[][] buscarPedido(int idPedido) {
        try {
            dbData.connectBD();
            informacionFilas = new ArrayList<>();
            String query = "SELECT p.idProducto, p.nombre, p.unidadMedida, pp.cantidad,"
                    + " pp.precioDeVenta, pp.totalDeVenta, pe.idCliente, pe.idVendedor, pe.estadoPedido"
                    + " FROM tb_productos as p INNER JOIN tb_pedido_producto as pp"
                    + " INNER JOIN tb_pedidos as pe WHERE p.idProducto = pp.idProducto"
                    + " AND pp.idPedido = ? AND pe.idPedido = ?";

            PreparedStatement comando = dbData.getConnect().prepareStatement(query);
            comando.setInt(1, idPedido);
            comando.setInt(2, idPedido);

            ResultSet resultado = comando.executeQuery();

            int filas = 0;
            while (resultado.next()) {
                filas++;
            }

            resultado = comando.executeQuery();
            String[][] informacion = new String[filas][9];

            filas = 0;
            while (resultado.next()) {
                informacion[filas][0] = resultado.getString(1);
                informacion[filas][1] = resultado.getString(2);
                informacion[filas][2] = resultado.getString(3);
                informacion[filas][3] = resultado.getString(4);
                informacion[filas][4] = resultado.getString(5);
                informacion[filas][5] = resultado.getString(6);
                informacion[filas][6] = resultado.getString(7);
                informacion[filas][7] = resultado.getString(8);
                informacion[filas][8] = resultado.getString(9);
                filas++;
            }

            dbData.disconnectBD();
            return informacion;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void actualizarPedido(String estadoPedido, String idPedido) {
        try {
            dbData.connectBD();
            String query = "UPDATE tb_pedidos SET estadoPedido = ? WHERE idPedido =  ?";

            PreparedStatement comando = dbData.getConnect().prepareStatement(query);

            comando.setString(1, estadoPedido);
            comando.setString(2, idPedido);
            int resultado = comando.executeUpdate();

            dbData.disconnectBD();
        } catch (Exception e) {
        }
    }

}
