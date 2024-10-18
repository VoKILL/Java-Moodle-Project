package repositories.interfaces;

import models.users.User;
import java.util.Map;

public interface UserRepositoryInterface {
    void addUser(User user);
    User getUserById(int userId);
    Map<Integer, User> getAllUsers();
    void updateUser(int userId, User updatedUser);
    void deleteUser(int userId);
}
