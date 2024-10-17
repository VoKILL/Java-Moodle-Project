package models.homework.grades.interfaces;

import models.homework.Homework;
import models.people.Student;

public interface GradeInterface {
    Student getStudent();
    void setStudent(Student student);

    Homework getHomework();
    void setHomework(Homework homework);

    double getScore();
    void setScore(double score);
}
