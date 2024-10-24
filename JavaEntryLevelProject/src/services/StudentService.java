package services;

import models.users.Student;
import repositories.interfaces.UserRepositoryInterface;
import services.interfaces.CourseServiceInterface;
import services.interfaces.HomeworkServiceInterface;
import services.interfaces.StudentServiceInterface;

public class StudentService implements StudentServiceInterface {
    private UserRepositoryInterface userRepository;
    private CourseServiceInterface courseService;
    private HomeworkServiceInterface homeworkService;

    public StudentService(UserRepositoryInterface userRepository,
                          CourseServiceInterface courseService,
                          HomeworkServiceInterface homeworkService) {
        this.userRepository = userRepository;
        this.courseService = courseService;
        this.homeworkService = homeworkService;
    }

    @Override
    public void enrollInCourse(int studentId, int courseId) {
        Student student = (Student) userRepository.getUserById(studentId);
        if (student == null) {
            throw new IllegalArgumentException("Student not found.");
        }

        courseService.addStudentToCourse(studentId, courseId);
        student.addCourseId(courseId);
        userRepository.updateUser(studentId, student);
    }

    @Override
    public void submitHomework(int studentId, int courseId, String title, String description) {
        Student student = (Student) userRepository.getUserById(studentId);

        if (student == null) {
            throw new IllegalArgumentException("Student not found.");
        }
        if (!student.getCourseIds().contains(courseId)) {
            throw new IllegalArgumentException("Student is not enrolled in the course.");
        }

        homeworkService.createHomework(title, description, courseId, studentId);
    }

    @Override
    public void viewHomework(int studentId, int courseId) {
        Student student = (Student) userRepository.getUserById(studentId);

        if (student == null) {
            throw new IllegalArgumentException("Student not found.");
        }
        if (!student.getCourseIds().contains(courseId)) {
            throw new IllegalArgumentException("Student is not enrolled in the course.");
        }

        homeworkService.viewHomeworkByStudentAndCourse(studentId, courseId);
    }
}
