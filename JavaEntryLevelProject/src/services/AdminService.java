package services;

import models.users.User;
import models.users.Teacher;
import repositories.interfaces.UserRepositoryInterface;
import repositories.interfaces.CourseRepositoryInterface;
import services.interfaces.AdminServiceInterface;

public class AdminService implements AdminServiceInterface {
    private UserRepositoryInterface userRepository;
    private CourseRepositoryInterface courseRepository;

    public AdminService(UserRepositoryInterface userRepository, CourseRepositoryInterface courseRepository) {
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void blockUser(int userId) {
        User user = userRepository.getUserById(userId);
        if (user != null && !user.isBlocked()) {
            user.setBlocked(true);
            userRepository.updateUser(userId, user);
        } else {
            throw new IllegalArgumentException("User not found or already blocked.");
        }
    }

    @Override
    public void unblockUser(int userId) {
        User user = userRepository.getUserById(userId);
        if (user != null && user.isBlocked()) {
            user.setBlocked(false);
            userRepository.updateUser(userId, user);
        } else {
            throw new IllegalArgumentException("User not found or not blocked.");
        }
    }

    @Override
    public void deleteUser(int userId) {
        User user = userRepository.getUserById(userId);
        if (user != null && !user.isDeleted()) {
            user.setDeleted(true);
            userRepository.updateUser(userId, user);
        } else {
            throw new IllegalArgumentException("User not found or already deleted.");
        }
    }

    @Override
    public void assignCourseToTeacher(int teacherId, int courseId) {
        User user = userRepository.getUserById(teacherId);
        if (user != null && user instanceof Teacher) {
            Teacher teacher = (Teacher) user;
            teacher.addCourseId(courseId);
            userRepository.updateUser(teacherId, teacher);
        } else {
            throw new IllegalArgumentException("Invalid teacher ID or user is not a teacher.");
        }
    }

    @Override
    public void removeCourseFromTeacher(int teacherId, int courseId) {
        User user = userRepository.getUserById(teacherId);
        if (user != null && user instanceof Teacher) {
            Teacher teacher = (Teacher) user;
            teacher.removeCourseId(courseId);
            userRepository.updateUser(teacherId, teacher);
        } else {
            throw new IllegalArgumentException("Invalid teacher ID or user is not a teacher.");
        }
    }
}
