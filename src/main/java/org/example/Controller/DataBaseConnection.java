package org.example.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * A singleton class responsible for managing a single database connection instance.
 * <p>
 * This pattern ensures that only one connection is used throughout the entire program,
 * which helps conserve system resources, as database connections can be expensive.
 */
public class DataBaseConnection {

    /**
     * The database URL. Replace {@code System.getenv("url")} with your actual MySQL URL if needed.
     */
    private static final String URL = System.getenv("url");

    /**
     * The database username. Replace {@code System.getenv("user")} with your actual MySQL username (e.g., "root").
     */
    private static final String USER = System.getenv("user");

    /**
     * The database password. Replace {@code System.getenv("password")} with your actual MySQL password.
     */
    private static final String PASSWORD = System.getenv("password");

    /**
     * Singleton instance of {@code DataBaseConnection}.
     */
    private static final DataBaseConnection instance = new DataBaseConnection();

    private Connection con;

    // Private constructor to prevent external instantiation
    private DataBaseConnection() {
        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Provides access to the singleton instance of {@code DataBaseConnection}.
     *
     * @return the singleton instance
     */
    public static DataBaseConnection getInstance() {
        return instance;
    }

    /**
     * Returns a valid {@link Connection} object.
     * If the connection is closed or null, a new connection is established.
     *
     * @return a valid database connection
     */
    public Connection getConnection() {
        try {
            if (con == null || con.isClosed()) {
                con = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Consider logging
        }
        return con;
    }
}
