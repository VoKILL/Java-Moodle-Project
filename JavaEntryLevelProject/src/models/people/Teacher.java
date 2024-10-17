package models.people;

import java.util.HashSet;
import java.util.Set;

public class Teacher extends User {
    private String subject;
    private Set<Integer> courseIds;

    public Teacher(int id, String email, String password, String subject) {
        super(id, email, password, true);
        this.subject = subject;
        this.courseIds = new HashSet<>();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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
}
