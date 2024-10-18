package repositories;

import models.courses.Course;
import models.courses.Homework;
import models.users.Student;
import models.users.Teacher;
import models.users.User;

import java.util.HashMap;
import java.util.Map;

public class DatabaseSimulator {
    private Map<Integer, User> users;
    private Map<Integer, Course> courses;
    private Map<Integer, Homework> homeworks;

    public DatabaseSimulator() {
        this.users = new HashMap<>();
        this.courses = new HashMap<>();
        this.homeworks = new HashMap<>();

        initializeData();
    }

    private void initializeData() {
        Teacher teacher = new Teacher(1, "teacher@example.com", "password", "Mathematics");
        Student student = new Student(2, "student@example.com", "password", "S12345");
        Course course = new Course(1, "Math 101", teacher.getId(), java.time.LocalDate.now(), java.time.LocalDate.now().plusMonths(3));
        Homework homework = new Homework(1, "Algebra Assignment", "Solve algebraic equations", course.getId(), student.getId(), java.time.LocalDate.now().plusWeeks(1), 0);

        users.put(teacher.getId(), teacher);
        users.put(student.getId(), student);
        courses.put(course.getId(), course);
        homeworks.put(homework.getId(), homework);
    }

    public Map<Integer, User> getUsers() {
        return users;
    }

    public Map<Integer, Course> getCourses() {
        return courses;
    }

    public Map<Integer, Homework> getHomeworks() {
        return homeworks;
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public void addCourse(Course course) {
        courses.put(course.getId(), course);
    }

    public void addHomework(Homework homework) {
        homeworks.put(homework.getId(), homework);
    }

    public void removeUser(int userId) {
        users.remove(userId);
    }

    public void removeCourse(int courseId) {
        courses.remove(courseId);
    }

    public void removeHomework(int homeworkId) {
        homeworks.remove(homeworkId);
    }
}
