package com.rajdeep.dao;
import com.rajdeep.db.DatabaseConnection;
import com.rajdeep.model.Student;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.*;
public class StudentDAO {
   public String url = "jdbc:sqlite:C:/WorkSpace/03_CODING/SQL/DATABASES/learning.db";

    public void insertStudent(Student student) {
        String sql = "INSERT INTO Students(StudentID, Name, Age, Major) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.connect(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, student.getStudentID());
            pstmt.setString(2, student.getName());
            pstmt.setInt(3, student.getAge());
            pstmt.setString(4, student.getMajor());

            pstmt.executeUpdate();
            System.out.println("✅ Student inserted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // 2️⃣ Fetch all students
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM Students";

        try (Connection conn = DatabaseConnection.connect(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Student s = new Student(
                        rs.getInt("StudentId"),
                        rs.getString("Name"),
                        rs.getInt("Age"),
                        rs.getString("Major")
                );
                students.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    // 3️⃣ Get a student by ID
    public Student getStudentById(int id) {
        String sql = "SELECT * FROM Students WHERE StudentId = ?";
        try (Connection conn = DatabaseConnection.connect(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Student(
                        rs.getInt("StudentId"),
                        rs.getString("Name"),
                        rs.getInt("Age"),
                        rs.getString("Major")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // 4️⃣ Update student info
    public void updateStudent(Student student) {
        String sql = "UPDATE Students SET Name = ?, Age = ?, Major = ? WHERE StudentId = ?";
        try (Connection conn = DatabaseConnection.connect(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, student.getName());
            pstmt.setInt(2, student.getAge());
            pstmt.setString(3, student.getMajor());
            pstmt.setInt(4, student.getStudentId());

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Student updated successfully.");
            } else {
                System.out.println("⚠️ No student found with that ID.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 5️⃣ Delete student by ID
    public void deleteStudent(int id) {
        String sql = "DELETE FROM Students WHERE StudentId = ?";
        try (Connection conn = DatabaseConnection.connect(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("🗑️ Student deleted successfully.");
            } else {
                System.out.println("⚠️ No student found with that ID.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 6️⃣ Count total students
    public int countStudents() {
        String sql = "SELECT COUNT(*) FROM Students";
        try (Connection conn = DatabaseConnection.connect(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
