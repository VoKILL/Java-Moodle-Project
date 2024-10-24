package repositories;

import models.users.User;
import repositories.interfaces.UserRepositoryInterface;

import java.util.HashMap;
import java.util.Map;

public class LocalUserRepository implements UserRepositoryInterface {
    private Map<Integer, User> users;

    public LocalUserRepository() {
        this.users = new HashMap<>();
    }

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
}
