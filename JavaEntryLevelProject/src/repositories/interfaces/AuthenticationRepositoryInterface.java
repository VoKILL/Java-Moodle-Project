package repositories.interfaces;

public interface AuthenticationRepositoryInterface {
    void addAuthenticatedUser(int userId, String token);
    void removeAuthenticatedUser(int userId);
    boolean isAuthenticated(int userId);
}
