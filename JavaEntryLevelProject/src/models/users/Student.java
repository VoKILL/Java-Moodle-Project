package models.users;

import constants.GlobalConstants;

import java.util.HashSet;
import java.util.Set;

public class Student extends User {
    private String studentId;
    private Set<Integer> courseIds;
    private Set<Integer> gradeIds;

    public Student(String email, String password) {
        super(email, password);
        this.studentId = GlobalConstants.generateStudentId();
        this.courseIds = new HashSet<>();
        this.gradeIds = new HashSet<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Set<Integer> getCourseIds() {
        return courseIds;
    }

    public void addCourseId(int courseId) {
        this.courseIds.add(courseId);
    }

    public void removeCourseId(int courseId) {
        this.courseIds.remove(courseId);
    }

    public Set<Integer> getGradeIds() {
        return gradeIds;
    }

    public void addGradeId(int gradeId) {
        this.gradeIds.add(gradeId);
    }

    public void removeGradeId(int gradeId) {
        this.gradeIds.remove(gradeId);
    }
}
