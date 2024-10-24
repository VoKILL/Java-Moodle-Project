package services;

import models.users.User;
import repositories.interfaces.AuthenticationRepositoryInterface;
import repositories.interfaces.UserRepositoryInterface;
import services.interfaces.AuthenticationServiceInterface;

public class AuthenticationService implements AuthenticationServiceInterface {
    private UserRepositoryInterface userRepository;
    private AuthenticationRepositoryInterface authenticatedUserRepository;

    public AuthenticationService(UserRepositoryInterface userRepository,
                                 AuthenticationRepositoryInterface authenticatedUserRepository) {
        this.userRepository = userRepository;
        this.authenticatedUserRepository = authenticatedUserRepository;
    }

    @Override
    public boolean authenticate(String email, String password) {
        for (User user : userRepository.getAllUsers().values()) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                String token = generateToken(user.getId());
                authenticatedUserRepository.addAuthenticatedUser(user.getId(), token);
                return true;
            }
        }
        return false;
    }

    @Override
    public void logout(int userId) {
        authenticatedUserRepository.removeAuthenticatedUser(userId);
    }

    @Override
    public boolean isAuthenticated(int userId) {
        return authenticatedUserRepository.isAuthenticated(userId);
    }

    private String generateToken(int userId) {
        return "token_" + userId + "_" + System.currentTimeMillis();
    }
}
