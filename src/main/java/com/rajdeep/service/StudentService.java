package com.rajdeep.service;

import com.rajdeep.dao.StudentDAO;
import com.rajdeep.model.Student;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {
    private final StudentDAO studentDAO;

    public StudentService(StudentDAO studentDAO)
    {
        this.studentDAO = studentDAO;
    }
    public void addStudent(Student student) {
        studentDAO.insertStudent(student);
    }

    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    public Student getStudentById(int id) {
        return studentDAO.getStudentById(id);
    }

    public void updateStudent(Student student) {
        studentDAO.updateStudent(student);
    }

    public void deleteStudent(int id) {
        studentDAO.deleteStudent(id);
    }

    public int countStudents() {
        return studentDAO.countStudents();
    }
}
