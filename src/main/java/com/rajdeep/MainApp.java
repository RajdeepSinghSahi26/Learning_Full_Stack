package com.rajdeep;

import com.rajdeep.db.DatabaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainApp {
    public static void main(String[] args) {
        // Step 1: Open a connection
        String url = "jdbc:sqlite:C:/WorkSpace/03_CODING/SQL/DATABASES/learning.db";
        try (Connection conn = DatabaseConnection.connect(url)) {
            System.out.println("Connected to SQLite successfully!");

            // Step 2: Create a statement
            Statement stmt = conn.createStatement();

            // Step 3: Execute query
            String sql = "SELECT * FROM Students;";
            ResultSet rs = stmt.executeQuery(sql);

            // Step 4: Process results
            while (rs.next()) {
                int id = rs.getInt("Age");
                String name = rs.getString("Name");
                System.out.println("Age: " + id + ", Name: " + name);
            }

        } catch (SQLException e) {
            System.out.println("Database connection failed:");
            e.printStackTrace();
        }
    }
}
