package repositories;

import models.courses.Homework;
import repositories.interfaces.HomeworkRepositoryInterface;

import java.util.HashMap;
import java.util.Map;

public class LocalHomeworkRepository implements HomeworkRepositoryInterface {
    private Map<Integer, Homework> homeworks;

    public LocalHomeworkRepository() {
        this.homeworks = new HashMap<>();
    }

    @Override
    public void addHomework(Homework homework) {
        homeworks.put(homework.getId(), homework);
    }

    @Override
    public Homework getHomeworkById(int homeworkId) {
        return homeworks.get(homeworkId);
    }

    @Override
    public Map<Integer, Homework> getAllHomeworks() {
        return homeworks;
    }

    @Override
    public void updateHomework(int homeworkId, Homework updatedHomework) {
        homeworks.put(homeworkId, updatedHomework);
    }

    @Override
    public void deleteHomework(int homeworkId) {
        homeworks.remove(homeworkId);
    }
}
