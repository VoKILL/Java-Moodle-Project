package services.interfaces;

public interface TeacherServiceInterface {
    void createCourse(int teacherId, String courseName, String startDate, String endDate);
    void assignHomework(int teacherId, int courseId, String title, String description);
    void gradeHomework(int teacherId, int homeworkId, double grade);
    void viewStudentsInCourse(int teacherId, int courseId);
}
