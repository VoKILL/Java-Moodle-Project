package services;

import models.courses.Course;
import models.courses.Homework;
import repositories.interfaces.CourseRepositoryInterface;
import repositories.interfaces.HomeworkRepositoryInterface;
import repositories.interfaces.UserRepositoryInterface;
import services.interfaces.CourseServiceInterface;

import java.time.LocalDate;

public class CourseService implements CourseServiceInterface {
    private CourseRepositoryInterface courseRepository;
    private UserRepositoryInterface userRepository;
    private HomeworkRepositoryInterface homeworkRepository;

    public CourseService(CourseRepositoryInterface courseRepository,
                         UserRepositoryInterface userRepository,
                         HomeworkRepositoryInterface homeworkRepository) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
        this.homeworkRepository = homeworkRepository;
    }

    @Override
    public Course createCourse(String courseName, int teacherId, String startDate, String endDate) {
        if (userRepository.getUserById(teacherId) == null) {
            throw new IllegalArgumentException("Teacher not found.");
        }

        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        Course course = new Course(courseName, teacherId, start, end);
        courseRepository.addCourse(course);
        return course;
    }

    @Override
    public void addStudentToCourse(int studentId, int courseId) {
        Course course = courseRepository.getCourseById(courseId);
        if (course == null) {
            throw new IllegalArgumentException("Course not found.");
        }
        if (userRepository.getUserById(studentId) == null) {
            throw new IllegalArgumentException("Student not found.");
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
        if (!course.getStudentIds().contains(studentId)) {
            throw new IllegalArgumentException("Student not enrolled in this course.");
        }

        course.removeStudentId(studentId);
        courseRepository.updateCourse(courseId, course);
    }

    @Override
    public void addHomeworkToCourse(int courseId, Homework homework) {
        Course course = courseRepository.getCourseById(courseId);
        if (course == null) {
            throw new IllegalArgumentException("Course not found.");
        }

        homeworkRepository.addHomework(homework);
        course.addHomeworkId(homework.getId());
        courseRepository.updateCourse(courseId, course);
    }
}
