package services.interfaces;

public interface StudentServiceInterface {
    void enrollInCourse(int studentId, int courseId);
    void submitHomework(int studentId, int courseId, String title, String description);
    void viewHomework(int studentId, int courseId);
}
