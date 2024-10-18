package repositories.interfaces;

import models.courses.Course;
import java.util.Map;

public interface CourseRepositoryInterface {
    void addCourse(Course course);
    Course getCourseById(int courseId);
    Map<Integer, Course> getAllCourses();
    void updateCourse(int courseId, Course updatedCourse);
    void deleteCourse(int courseId);
}
