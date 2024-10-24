package services;

import models.users.User;
import repositories.interfaces.UserRepositoryInterface;
import services.interfaces.AuthenticationServiceInterface;

import java.util.HashMap;
import java.util.Map;


public class AuthenticationService implements AuthenticationServiceInterface {
    private Map<Integer, String> authenticatedUsers;
    private UserRepositoryInterface userRepository;


    public AuthenticationService(UserRepositoryInterface userRepository) {
        this.userRepository = userRepository;
        this.authenticatedUsers = new HashMap<>();
    }

    @Override
    public boolean authenticate(String email, String password) {
        for (User user : userRepository.getAllUsers().values()) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                String token = generateToken(user.getId());
                authenticatedUsers.put(user.getId(), token);
                return true;
            }
        }
        return false;
    }

    @Override
    public void logout(int userId) {
        authenticatedUsers.remove(userId);
    }

    @Override
    public boolean isAuthenticated(int userId) {
        return authenticatedUsers.containsKey(userId);
    }

    private String generateToken(int userId) {
        return "token_" + userId + "_" + System.currentTimeMillis();
    }
}
