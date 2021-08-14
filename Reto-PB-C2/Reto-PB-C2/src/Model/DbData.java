/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;

/**
 *
 * @author Leonardo Perdomo
 */
public class DbData {

    /* Para conectarse con mySQL */
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String user = "root";
    private final String password = "";
    private final String url = "jdbc:mysql://localhost:3306/administracionproductos";
    private Connection connect;
    
    public void connectBD() {
        try {
            connect = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void disconnectBD() {
        try {
            connect.close();            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getDriver() {
        return driver;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }
    
    public Connection getConnect() {
        return connect;
    }

}
