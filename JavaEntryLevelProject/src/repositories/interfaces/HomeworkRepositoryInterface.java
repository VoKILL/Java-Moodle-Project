package repositories.interfaces;

import models.courses.Homework;
import java.util.Map;

public interface HomeworkRepositoryInterface {
    void addHomework(Homework homework);
    Homework getHomeworkById(int homeworkId);
    Map<Integer, Homework> getAllHomeworks();
    void updateHomework(int homeworkId, Homework updatedHomework);
    void deleteHomework(int homeworkId);
}
