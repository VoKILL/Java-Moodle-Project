package services;

import constants.GlobalConstants;
import models.courses.Course;
import repositories.interfaces.CourseRepositoryInterface;
import services.interfaces.CourseServiceInterface;

import java.time.LocalDate;
import java.util.Set;

public class CourseService implements CourseServiceInterface {
    private CourseRepositoryInterface courseRepository;

    public CourseService(CourseRepositoryInterface courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course createCourse(String courseName, int teacherId, String startDate, String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        int courseId = GlobalConstants.generateCourseId();
        Course course = new Course(courseId, courseName, teacherId, start, end);
        courseRepository.addCourse(course);
        return course;
    }

    @Override
    public void addStudentToCourse(int studentId, int courseId) {
        Course course = courseRepository.getCourseById(courseId);
        if (course == null) {
            throw new IllegalArgumentException("Course not found.");
        }

        course.addStudentId(studentId);
        courseRepository.updateCourse(courseId, course);
    }

    @Override
    public void removeStudentFromCourse(int studentId, int courseId) {
        Course course = courseRepository.getCourseById(courseId);
        if (course == null) {
            throw new IllegalArgumentException("Course not found.");
        }

        course.removeStudentId(studentId);
        courseRepository.updateCourse(courseId, course);
    }

    @Override
    public Set<Integer> getStudentIdsInCourse(int courseId) {
        Course course = courseRepository.getCourseById(courseId);
        if (course == null) {
            throw new IllegalArgumentException("Course not found.");
        }
        return course.getStudentIds();
    }
}
