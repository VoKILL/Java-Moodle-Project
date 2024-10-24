package services;

import constants.GlobalConstants;
import models.courses.Course;
import models.courses.Homework;
import models.users.Teacher;
import repositories.interfaces.CourseRepositoryInterface;
import repositories.interfaces.HomeworkRepositoryInterface;
import repositories.interfaces.UserRepositoryInterface;
import services.interfaces.TeacherServiceInterface;

import java.time.LocalDate;
import java.util.Set;

public class TeacherService implements TeacherServiceInterface {
    private UserRepositoryInterface userRepository;
    private CourseRepositoryInterface courseRepository;
    private HomeworkRepositoryInterface homeworkRepository;

    public TeacherService(UserRepositoryInterface userRepository,
                          CourseRepositoryInterface courseRepository,
                          HomeworkRepositoryInterface homeworkRepository) {
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
        this.homeworkRepository = homeworkRepository;
    }

    @Override
    public void createCourse(int teacherId, String courseName, String startDate, String endDate) {
        Teacher teacher = (Teacher) userRepository.getUserById(teacherId);

        if (teacher == null) {
            throw new IllegalArgumentException("Teacher not found.");
        }

        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        int courseId = GlobalConstants.generateCourseId();
        Course course = new Course(courseId, courseName, teacherId, start, end);
        courseRepository.addCourse(course);
        teacher.addCourseId(course.getId());

        userRepository.updateUser(teacherId, teacher);
    }

    @Override
    public void assignHomework(int teacherId, int courseId, String title, String description) {
        Teacher teacher = (Teacher) userRepository.getUserById(teacherId);
        Course course = courseRepository.getCourseById(courseId);

        if (teacher == null || !teacher.getCourseIds().contains(courseId)) {
            throw new IllegalArgumentException("Teacher not found or does not teach this course.");
        }

        int homeWorkId = GlobalConstants.generateHomeworkId();
        Homework homework = new Homework(homeWorkId, title, description, courseId, -1, LocalDate.now().plusWeeks(1)); // Student ID not needed for creation
        homeworkRepository.addHomework(homework);
        course.addHomeworkId(homework.getId());

        courseRepository.updateCourse(courseId, course);
    }

    @Override
    public void gradeHomework(int teacherId, int homeworkId, double grade) {
        Teacher teacher = (Teacher) userRepository.getUserById(teacherId);
        Homework homework = homeworkRepository.getHomeworkById(homeworkId);

        if (teacher == null || homework == null) {
            throw new IllegalArgumentException("Teacher or Homework not found.");
        }

        homework.setGrade(grade);
        homeworkRepository.updateHomework(homeworkId, homework);
    }

    @Override
    public void viewStudentsInCourse(int teacherId, int courseId) {
        Teacher teacher = (Teacher) userRepository.getUserById(teacherId);
        Course course = courseRepository.getCourseById(courseId);

        if (teacher == null || !teacher.getCourseIds().contains(courseId)) {
            throw new IllegalArgumentException("Teacher not found or does not teach this course.");
        }

        Set<Integer> studentIds = course.getStudentIds();
        for (int studentId : studentIds) {
            System.out.println(userRepository.getUserById(studentId));
        }
    }
}
