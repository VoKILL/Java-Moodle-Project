package services;

import constants.GlobalConstants;
import models.courses.Homework;
import repositories.interfaces.HomeworkRepositoryInterface;
import services.interfaces.HomeworkServiceInterface;

import java.time.LocalDate;
import java.util.Map;

public class HomeworkService implements HomeworkServiceInterface {
    private HomeworkRepositoryInterface homeworkRepository;

    public HomeworkService(HomeworkRepositoryInterface homeworkRepository) {
        this.homeworkRepository = homeworkRepository;
    }

    @Override
    public void createHomework(String title, String description, int courseId, int studentId) {
        int homeworkId = GlobalConstants.generateHomeworkId();
        Homework homework = new Homework(homeworkId, title, description, courseId, studentId, LocalDate.now().plusWeeks(1));
        homeworkRepository.addHomework(homework);
    }

    @Override
    public void submitHomework(int homeworkId) {
        Homework homework = homeworkRepository.getHomeworkById(homeworkId);
        if (homework == null) {
            throw new IllegalArgumentException("Homework not found.");
        }
        // Логика за подаване на домашно
        System.out.println("Homework with ID " + homeworkId + " has been submitted.");
    }

    @Override
    public void gradeHomework(int homeworkId, double grade) {
        Homework homework = homeworkRepository.getHomeworkById(homeworkId);
        if (homework == null) {
            throw new IllegalArgumentException("Homework not found.");
        }
        homework.setGrade(grade);
        homeworkRepository.updateHomework(homeworkId, homework);
    }

    @Override
    public Homework viewHomework(int homeworkId) {
        Homework homework = homeworkRepository.getHomeworkById(homeworkId);
        if (homework == null) {
            throw new IllegalArgumentException("Homework not found.");
        }
        return homework;
    }

    @Override
    public void viewHomeworkByStudentAndCourse(int studentId, int courseId) {
        Map<Integer, Homework> allHomeworks = homeworkRepository.getAllHomeworks();
        for (Homework homework : allHomeworks.values()) {
            if (homework.getStudentId() == studentId && homework.getCourseId() == courseId) {
                System.out.println("Homework: " + homework.getTitle() + " - " + homework.getDescription());
            }
        }
    }
}
