package org.example.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    private static final String URL = System.getenv("url");
    private static final String USER = System.getenv("user");
    private static final String PASSWORD = System.getenv("password");
    private Connection con;
    private static final DataBaseConnection instance = new DataBaseConnection();
    private DataBaseConnection() {
        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static DataBaseConnection getInstance() {
        return instance;
    }
    public  Connection getConnection() {
        try {
            if (con == null || con.isClosed()) {
                con = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}