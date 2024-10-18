package services.interfaces;

public interface AdminServiceInterface {
    void blockUser(int userId);
    void unblockUser(int userId);
    void deleteUser(int userId);
    void assignCourseToTeacher(int teacherId, int courseId);
    void removeCourseFromTeacher(int teacherId, int courseId);
}
