package com.rajdeep.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // 1. Method to open connection
    public static Connection connect(String url ) throws SQLException {
 // 2. Open and return the connection
        return DriverManager.getConnection(url);
    }
}

