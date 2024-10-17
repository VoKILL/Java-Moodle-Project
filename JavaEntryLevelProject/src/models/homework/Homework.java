package models.homework;

import models.homework.grades.Grade;
import models.homework.interfaces.HomeworkInterface;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Homework implements HomeworkInterface {
    private String title;
    private String description;
    private Date dueDate;
    private List<Grade> grades;

    public Homework(String title, String description, Date dueDate) {
        setTitle(title);
        setDescription(description);
        setDueDate(dueDate);
        this.grades = new ArrayList<>();
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty.");
        }
        this.title = title;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Description cannot be null or empty.");
        }
        this.description = description;
    }

    @Override
    public Date getDueDate() {
        return dueDate;
    }

    @Override
    public void setDueDate(Date dueDate) {
        if (dueDate == null || dueDate.before(new Date())) {
            throw new IllegalArgumentException("Due date cannot be null or in the past.");
        }
        this.dueDate = dueDate;
    }

    @Override
    public List<Grade> getGrades() {
        return grades;
    }

    @Override
    public void addGrade(Grade grade) {
        if (grade == null) {
            throw new IllegalArgumentException("Grade cannot be null.");
        }
        if (!grades.contains(grade)) {
            grades.add(grade);
        }
    }

    @Override
    public void removeGrade(Grade grade) {
        grades.remove(grade);
    }
}
