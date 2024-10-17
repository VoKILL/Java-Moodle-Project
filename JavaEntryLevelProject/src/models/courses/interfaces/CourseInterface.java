package models.courses.interfaces;

import models.homework.Homework;
import models.people.Teacher;
import models.people.Student;
import java.util.List;

public interface CourseInterface {
    String getCourseName();
    void setCourseName(String courseName);

    String getCourseCode();
    void setCourseCode(String courseCode);

    Teacher getTeacher();
    void setTeacher(Teacher teacher);

    List<Student> getStudents();
    void addStudent(Student student);
    void removeStudent(Student student);

    List<Homework> getHomeworks();
    void addHomework(Homework homework);
    void removeHomework(Homework homework);
}
