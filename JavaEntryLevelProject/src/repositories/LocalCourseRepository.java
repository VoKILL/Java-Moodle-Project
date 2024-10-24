package repositories;

import models.courses.Course;
import repositories.interfaces.CourseRepositoryInterface;

import java.util.HashMap;
import java.util.Map;

public class LocalCourseRepository implements CourseRepositoryInterface {
    private Map<Integer, Course> courses;

    public LocalCourseRepository() {
        this.courses = new HashMap<>();
    }

    @Override
    public void addCourse(Course course) {
        courses.put(course.getId(), course);
    }

    @Override
    public Course getCourseById(int courseId) {
        return courses.get(courseId);
    }

    @Override
    public Map<Integer, Course> getAllCourses() {
        return courses;
    }

    @Override
    public void updateCourse(int courseId, Course updatedCourse) {
        courses.put(courseId, updatedCourse);
    }

    @Override
    public void deleteCourse(int courseId) {
        courses.remove(courseId);
    }
}
