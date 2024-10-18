package models.courses;

import constants.GlobalConstants;

import java.time.LocalDate;

public class Homework {
    private int id;
    private String title;
    private String description;
    private int courseId;
    private int studentId;
    private LocalDate dueDate;
    private double grade;

    public Homework(String title, String description, int courseId, int studentId, LocalDate dueDate) {
        this.id = GlobalConstants.generateHomeworkId();
        this.title = title;
        this.description = description;
        this.courseId = courseId;
        this.studentId = studentId;
        this.dueDate = dueDate;
        this.grade = -1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
