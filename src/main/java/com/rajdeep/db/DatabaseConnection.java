package com.rajdeep.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // 1. Method to open connection
    public static Connection connect() throws SQLException {
        // 2. Database URL
        String url = "jdbc:sqlite:C:/WorkSpace/03_CODING/SQL/DATABASES/learning.db";;

        // 3. Open and return the connection
        return DriverManager.getConnection(url);
    }
}

