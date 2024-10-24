package services;

import models.users.Teacher;
import repositories.interfaces.UserRepositoryInterface;
import services.interfaces.CourseServiceInterface;
import services.interfaces.HomeworkServiceInterface;
import services.interfaces.TeacherServiceInterface;

import java.util.Set;

public class TeacherService implements TeacherServiceInterface {
    private UserRepositoryInterface userRepository;
    private CourseServiceInterface courseService;
    private HomeworkServiceInterface homeworkService;

    public TeacherService(UserRepositoryInterface userRepository,
                          CourseServiceInterface courseService,
                          HomeworkServiceInterface homeworkService) {
        this.userRepository = userRepository;
        this.courseService = courseService;
        this.homeworkService = homeworkService;
    }

    @Override
    public void createCourse(int teacherId, String courseName, String startDate, String endDate) {
        Teacher teacher = (Teacher) userRepository.getUserById(teacherId);

        if (teacher == null) {
            throw new IllegalArgumentException("Teacher not found.");
        }

        courseService.createCourse(courseName, teacherId, startDate, endDate);
        teacher.addCourseId(teacherId);  // Предполагам, че courseId трябва да се получи от създадения курс
        userRepository.updateUser(teacherId, teacher);
    }

    @Override
    public void assignHomework(int teacherId, int courseId, String title, String description) {
        Teacher teacher = (Teacher) userRepository.getUserById(teacherId);

        if (teacher == null || !teacher.getCourseIds().contains(courseId)) {
            throw new IllegalArgumentException("Teacher not found or does not teach this course.");
        }

        homeworkService.createHomework(title, description, courseId, -1);  // -1 означава, че домашното е за всички студенти
    }

    @Override
    public void gradeHomework(int teacherId, int homeworkId, double grade) {
        Teacher teacher = (Teacher) userRepository.getUserById(teacherId);

        if (teacher == null) {
            throw new IllegalArgumentException("Teacher not found.");
        }

        // Може да се добави проверка дали домашното е от курс, който преподава учителят
        homeworkService.gradeHomework(homeworkId, grade);
    }

    @Override
    public void viewStudentsInCourse(int teacherId, int courseId) {
        Teacher teacher = (Teacher) userRepository.getUserById(teacherId);

        if (teacher == null || !teacher.getCourseIds().contains(courseId)) {
            throw new IllegalArgumentException("Teacher not found or does not teach this course.");
        }

        Set<Integer> studentIds = courseService.getStudentIdsInCourse(courseId);
        for (int studentId : studentIds) {
            System.out.println(userRepository.getUserById(studentId));
        }
    }
}
