package models.courses;

import constants.GlobalConstants;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Course {
    private int id;
    private String courseName;
    private int teacherId;
    private Set<Integer> studentIds;
    private Set<Integer> homeworkIds;
    private LocalDate startDate;
    private LocalDate endDate;

    public Course(String courseName, int teacherId, LocalDate startDate, LocalDate endDate) {
        this.id = GlobalConstants.generateCourseId();
        this.courseName = courseName;
        this.teacherId = teacherId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.studentIds = new HashSet<>();
        this.homeworkIds = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public Set<Integer> getStudentIds() {
        return studentIds;
    }

    public void addStudentId(int studentId) {
        this.studentIds.add(studentId);
    }

    public void removeStudentId(int studentId) {
        this.studentIds.remove(studentId);
    }

    public Set<Integer> getHomeworkIds() {
        return homeworkIds;
    }

    public void addHomeworkId(int homeworkId) {
        this.homeworkIds.add(homeworkId);
    }

    public void removeHomeworkId(int homeworkId) {
        this.homeworkIds.remove(homeworkId);
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
