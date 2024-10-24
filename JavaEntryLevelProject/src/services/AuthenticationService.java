package services;

import models.users.User;
import repositories.interfaces.AuthenticationRepositoryInterface;
import repositories.interfaces.UserRepositoryInterface;
import services.interfaces.AuthenticationServiceInterface;

public class AuthenticationService implements AuthenticationServiceInterface {
    private UserRepositoryInterface userRepository;
    private AuthenticationRepositoryInterface authenticationRepository;

    public AuthenticationService(UserRepositoryInterface userRepository,
                                 AuthenticationRepositoryInterface authenticationRepository) {
        this.userRepository = userRepository;
        this.authenticationRepository = authenticationRepository;
    }

    @Override
    public boolean authenticate(String email, String password) {
        for (User user : userRepository.getAllUsers().values()) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                String token = generateToken(user.getId());
                authenticationRepository.addAuthenticatedUser(user.getId(), token);
                return true;
            }
        }
        return false;
    }

    @Override
    public void logout(int userId) {
        authenticationRepository.removeAuthenticatedUser(userId);
    }

    @Override
    public boolean isAuthenticated(int userId) {
        return authenticationRepository.isAuthenticated(userId);
    }

    private String generateToken(int userId) {
        return "token_" + userId + "_" + System.currentTimeMillis();
    }
}
