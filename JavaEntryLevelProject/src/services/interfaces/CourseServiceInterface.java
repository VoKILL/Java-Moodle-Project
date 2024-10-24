package services.interfaces;

import models.courses.Course;

import java.util.Set;

public interface CourseServiceInterface {
    Course createCourse(String courseName, int teacherId, String startDate, String endDate);
    void addStudentToCourse(int studentId, int courseId);
    void removeStudentFromCourse(int studentId, int courseId);
    Set<Integer> getStudentIdsInCourse(int courseId);
}
