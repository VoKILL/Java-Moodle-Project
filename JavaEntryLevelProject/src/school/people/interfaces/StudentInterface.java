package school.people.interfaces;

import school.homework.grades.Grade;

import java.util.List;

public interface StudentInterface extends PersonInterface {
    String getStudentId();
    void setStudentId(String studentId);

    List<Grade> getGrades();
    void addGrade(Grade grade);
}

