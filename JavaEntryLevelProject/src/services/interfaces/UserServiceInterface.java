package services.interfaces;

import models.users.User;

public interface UserServiceInterface {
    void register(String email, String password, boolean isAdmin);
    User getUserById(int id);
    void updateProfile(int userId, User updatedUser);
    void changePassword(int userId, String oldPassword, String newPassword);
}

