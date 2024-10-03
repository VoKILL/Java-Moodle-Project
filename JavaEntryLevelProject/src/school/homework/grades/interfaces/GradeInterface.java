package school.homework.grades.interfaces;

import school.homework.Homework;
import school.people.Student;

public interface GradeInterface {
    Student getStudent();
    void setStudent(Student student);

    Homework getHomework();
    void setHomework(Homework homework);

    double getScore();
    void setScore(double score);
}
