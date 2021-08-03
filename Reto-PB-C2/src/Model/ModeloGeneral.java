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
public class ModeloGeneral {
    
    private final DbData dbData;

    public ModeloGeneral() {
        this.dbData = new DbData();
    }
    
    public String obtenerId(String idPersona, String nombreTablaDB) {
        try ( Connection conexion = DriverManager.getConnection(dbData.getUrl(),
                dbData.getUser(), dbData.getPassword())) {
            String query = "SELECT MAX(id"+idPersona+") AS id FROM tb_"+nombreTablaDB+"";

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
    
}
