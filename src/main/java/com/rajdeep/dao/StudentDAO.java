package com.rajdeep.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDAO {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:C:/WorkSpace/03_CODING/SQL/DATABASES/learning.db";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM students  ");) {

            while (rs.next()) {
                int id = rs.getInt("StudentID");
                String name = rs.getString("Name");
                int age = rs.getInt("Age");
                String major = rs.getString("Major");

                System.out.println(id + " | " + name + " | " + age + " | " + major);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
