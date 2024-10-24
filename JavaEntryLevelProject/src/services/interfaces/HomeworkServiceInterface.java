package services.interfaces;

import models.courses.Homework;

public interface HomeworkServiceInterface {
    void createHomework(String title, String description, int courseId, int studentId);
    void submitHomework(int homeworkId);
    void gradeHomework(int homeworkId, double grade);
    Homework viewHomework(int homeworkId);
    void viewHomeworkByStudentAndCourse(int studentId, int courseId);
}
