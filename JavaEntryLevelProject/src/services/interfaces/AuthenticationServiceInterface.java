package services.interfaces;

public interface AuthenticationServiceInterface {
    boolean authenticate(String email, String password);
    void logout(int userId);
    boolean isAuthenticated(int userId);
}