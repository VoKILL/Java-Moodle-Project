package services;

import models.courses.Homework;
import repositories.interfaces.CourseRepositoryInterface;
import repositories.interfaces.HomeworkRepositoryInterface;
import services.interfaces.HomeworkServiceInterface;

import java.time.LocalDate;

public class HomeworkService implements HomeworkServiceInterface {
    private HomeworkRepositoryInterface homeworkRepository;
    private CourseRepositoryInterface courseRepository;

    public HomeworkService(HomeworkRepositoryInterface homeworkRepository,
                           CourseRepositoryInterface courseRepository) {
        this.homeworkRepository = homeworkRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void createHomework(String title, String description, int courseId, int studentId) {
        if (courseRepository.getCourseById(courseId) == null) {
            throw new IllegalArgumentException("Course not found.");
        }

        Homework homework = new Homework(title, description, courseId, studentId, LocalDate.now().plusWeeks(1));
        homeworkRepository.addHomework(homework);
    }

    @Override
    public void submitHomework(int homeworkId) {
        Homework homework = homeworkRepository.getHomeworkById(homeworkId);
        if (homework == null) {
            throw new IllegalArgumentException("Homework not found.");
        }

        // Add logic for submission (in this case, it's as simple as confirming existence)
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
}
