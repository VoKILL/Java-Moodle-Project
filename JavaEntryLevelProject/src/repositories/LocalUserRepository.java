package repositories;

import repositories.interfaces.AuthenticationRepositoryInterface;
import repositories.interfaces.UserRepositoryInterface;
import models.users.User;

import java.util.HashMap;
import java.util.Map;

public class LocalUserRepository implements UserRepositoryInterface, AuthenticationRepositoryInterface {
    private Map<Integer, User> users;
    private Map<Integer, String> authenticatedUsers;

    public LocalUserRepository() {
        this.users = new HashMap<>();
        this.authenticatedUsers = new HashMap<>();
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

    @Override
    public void addAuthenticatedUser(int userId, String token) {
        authenticatedUsers.put(userId, token);
    }

    @Override
    public void removeAuthenticatedUser(int userId) {
        authenticatedUsers.remove(userId);
    }

    @Override
    public boolean isAuthenticated(int userId) {
        return authenticatedUsers.containsKey(userId);
    }
}
