package com.rajdeep;

import com.rajdeep.dao.StudentDAO;
import com.rajdeep.model.Student;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Insert Student");
            System.out.println("2. View All Students");
            System.out.println("3. Get Student By ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Count Students");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scan.nextInt();
            scan.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter ID: ");
                    int id = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scan.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Enter Major: ");
                    String major = scan.nextLine();
                    dao.insertStudent(new Student(id, name, age, major));
                }

                case 2 -> {
                    List<Student> students = dao.getAllStudents();
                    for (Student s : students) {
                        System.out.println(s);
                    }
                }

                case 3 -> {
                    System.out.print("Enter ID: ");
                    int id = scan.nextInt();
                    Student s = dao.getStudentById(id);
                    if (s != null) System.out.println(s);
                    else System.out.println("Student not found.");
                }

                case 4 -> {
                    System.out.print("Enter ID to update: ");
                    int id = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Enter New Name: ");
                    String name = scan.nextLine();
                    System.out.print("Enter New Age: ");
                    int age = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Enter New Major: ");
                    String major = scan.nextLine();
                    dao.updateStudent(new Student(id, name, age, major));
                }

                case 5 -> {
                    System.out.print("Enter ID to delete: ");
                    int id = scan.nextInt();
                    dao.deleteStudent(id);
                }

                case 6 -> {
                    int count = dao.countStudents();
                    System.out.println("Total Students: " + count);
                }

                case 0 -> {
                    System.out.println("Exiting...");
                    return;
                }

                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
