
package com.rajdeep;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class DatabaseTest implements CommandLineRunner {

    private static final String DB_URL = "jdbc:sqlite:C:/WorkSpace/03_CODING/SQL/DATABASES/learning.db";

    public static void main(String[] args) {
        SpringApplication.run(DatabaseTest.class, args);
    }

    @Override
    public void run(String... args) {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {

            System.out.println("Connected to SQLite!");


            ResultSet rs = stmt.executeQuery("SELECT * FROM Students");
            while (rs.next()) {
                int Age = rs.getInt("Age");
                String Name = rs.getString("Name");
                System.out.println("age: " + Age + ", Name: " + Name);
            }

            rs.close(); // Close ResultSet

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
