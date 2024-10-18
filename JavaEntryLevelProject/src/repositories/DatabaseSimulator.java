package repositories;

import models.courses.Course;
import models.courses.Homework;
import models.users.User;
import repositories.interfaces.CourseRepositoryInterface;
import repositories.interfaces.HomeworkRepositoryInterface;
import repositories.interfaces.UserRepositoryInterface;

import java.util.HashMap;
import java.util.Map;

public class DatabaseSimulator implements UserRepositoryInterface, CourseRepositoryInterface, HomeworkRepositoryInterface {
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
        //TODO: Initialize data
    }

    // UserRepositoryInterface methods
    @Override
    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public User getUserById(int userId) {
        return users.get(userId);
    }

    @Override
    public Map<Integer, User> getAllUsers() {
        return users;
    }

    @Override
    public void updateUser(int userId, User updatedUser) {
        users.put(userId, updatedUser);
    }

    @Override
    public void deleteUser(int userId) {
        users.remove(userId);
    }

    // CourseRepositoryInterface methods
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

    // HomeworkRepositoryInterface methods
    @Override
    public void addHomework(Homework homework) {
        homeworks.put(homework.getId(), homework);
    }

    @Override
    public Homework getHomeworkById(int homeworkId) {
        return homeworks.get(homeworkId);
    }

    @Override
    public Map<Integer, Homework> getAllHomeworks() {
        return homeworks;
    }

    @Override
    public void updateHomework(int homeworkId, Homework updatedHomework) {
        homeworks.put(homeworkId, updatedHomework);
    }

    @Override
    public void deleteHomework(int homeworkId) {
        homeworks.remove(homeworkId);
    }
}
