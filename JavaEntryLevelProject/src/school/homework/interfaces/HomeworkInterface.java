package school.homework.interfaces;

import school.homework.grades.Grade;

import java.util.Date;
import java.util.List;

public interface HomeworkInterface {
    String getTitle();
    void setTitle(String title);

    String getDescription();
    void setDescription(String description);

    Date getDueDate();
    void setDueDate(Date dueDate);

    List<Grade> getGrades();
    void addGrade(Grade grade);
    void removeGrade(Grade grade);
}
