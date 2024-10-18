package services;

import constants.GlobalConstants;
import models.users.User;
import repositories.interfaces.UserRepositoryInterface;
import services.interfaces.UserServiceInterface;

public class UserService implements UserServiceInterface {
    private UserRepositoryInterface userRepository;

    public UserService(UserRepositoryInterface userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void register(String email, String password, boolean isAdmin) {
        if (userRepository.getAllUsers().values().stream().anyMatch(u -> u.getEmail().equals(email))) {
            throw new IllegalArgumentException("User with this email already exists.");
        }

        int userId = GlobalConstants.generateUserId();
        User newUser = new User(userId, email, password);
        userRepository.addUser(newUser);
    }

    @Override
    public User getUserById(int id) {
        return userRepository.getUserById(id);
    }

    @Override
    public void updateProfile(int userId, User updatedUser) {
        if (userRepository.getUserById(userId) != null) {
            userRepository.updateUser(userId, updatedUser);
        } else {
            throw new IllegalArgumentException("User not found.");
        }
    }

    @Override
    public void changePassword(int userId, String oldPassword, String newPassword) {
        User user = userRepository.getUserById(userId);
        if (user != null && user.getPassword().equals(oldPassword)) {
            user.setPassword(newPassword);
            userRepository.updateUser(userId, user);
        } else {
            throw new IllegalArgumentException("Incorrect old password or user not found.");
        }
    }
}
