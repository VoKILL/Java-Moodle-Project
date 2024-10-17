package models.people;

import models.homework.grades.Grade;
import models.people.interfaces.StudentInterface;

import java.util.ArrayList;
import java.util.List;

public class Student extends User implements StudentInterface {
    private String name;
    private int age;
    private String studentId;
    private List<Grade> grades;

    public Student(String name, int age, String studentId, String username, String password, boolean isAdmin) {
        super(username, password, isAdmin);
        setName(name);
        setAge(age);
        setStudentId(studentId);
        this.grades = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        this.name = name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        if (age < 5 || age > 100) {
            throw new IllegalArgumentException("Age must be between 5 and 100.");
        }
        this.age = age;
    }

    @Override
    public String getStudentId() {
        return studentId;
    }

    @Override
    public void setStudentId(String studentId) {
        if (studentId == null || studentId.trim().isEmpty()) {
            throw new IllegalArgumentException("Student ID cannot be null or empty.");
        }
        this.studentId = studentId;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void addGrade(Grade grade) {
        if (grade == null) {
            throw new IllegalArgumentException("Grade cannot be null.");
        }
        if (!grades.contains(grade)) {
            grades.add(grade);
        }
    }
}
