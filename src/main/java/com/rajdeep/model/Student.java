package com.rajdeep.model;

public class Student {
    private int studentID;
    private String name;
    private int age;
    private String major;

    // Constructor
    public Student(int studentID, String name, int age, String major) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.major = major;
    }

    // Getters
    public int getStudentID() { return studentID; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getMajor() { return major; }

    // Setters
    public void setStudentID(int studentID) { this.studentID = studentID; }
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setMajor(String major) { this.major = major; }

    // toString for easy printing
    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + studentID +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", major='" + major + '\'' +
                '}';
    }
}

