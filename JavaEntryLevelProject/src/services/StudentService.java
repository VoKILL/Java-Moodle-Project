package services;

import models.courses.Course;
import models.courses.Homework;
import models.users.Student;
import repositories.interfaces.CourseRepositoryInterface;
import repositories.interfaces.HomeworkRepositoryInterface;
import repositories.interfaces.UserRepositoryInterface;
import services.interfaces.StudentServiceInterface;

import java.time.LocalDate;

public class StudentService implements StudentServiceInterface {
    private UserRepositoryInterface userRepository;
    private CourseRepositoryInterface courseRepository;
    private HomeworkRepositoryInterface homeworkRepository;

    public StudentService(UserRepositoryInterface userRepository,
                          CourseRepositoryInterface courseRepository,
                          HomeworkRepositoryInterface homeworkRepository) {
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
        this.homeworkRepository = homeworkRepository;
    }

    @Override
    public void enrollInCourse(int studentId, int courseId) {
        Student student = (Student) userRepository.getUserById(studentId);
        Course course = courseRepository.getCourseById(courseId);

        if (student == null) {
            throw new IllegalArgumentException("Student not found.");
        }
        if (course == null) {
            throw new IllegalArgumentException("Course not found.");
        }

        student.addCourseId(courseId);
        course.addStudentId(studentId);

        userRepository.updateUser(studentId, student);
        courseRepository.updateCourse(courseId, course);
    }

    @Override
    public void submitHomework(int studentId, int courseId, String title, String description) {
        Student student = (Student) userRepository.getUserById(studentId);
        Course course = courseRepository.getCourseById(courseId);

        if (student == null) {
            throw new IllegalArgumentException("Student not found.");
        }
        if (course == null) {
            throw new IllegalArgumentException("Course not found.");
        }
        if (!student.getCourseIds().contains(courseId)) {
            throw new IllegalArgumentException("Student is not enrolled in the course.");
        }

        Homework homework = new Homework(title, description, courseId, studentId, LocalDate.now().plusWeeks(1));
        homeworkRepository.addHomework(homework);
        course.addHomeworkId(homework.getId());

        courseRepository.updateCourse(courseId, course);
    }

    @Override
    public void viewHomework(int studentId, int courseId) {
        Student student = (Student) userRepository.getUserById(studentId);
        Course course = courseRepository.getCourseById(courseId);

        if (student == null) {
            throw new IllegalArgumentException("Student not found.");
        }
        if (course == null) {
            throw new IllegalArgumentException("Course not found.");
        }
        if (!student.getCourseIds().contains(courseId)) {
            throw new IllegalArgumentException("Student is not enrolled in the course.");
        }

        for (int homeworkId : course.getHomeworkIds()) {
            Homework homework = homeworkRepository.getHomeworkById(homeworkId);
            if (homework.getStudentId() == studentId) {
                System.out.println("Homework: " + homework.getTitle() + " - " + homework.getDescription());
            }
        }
    }
}
