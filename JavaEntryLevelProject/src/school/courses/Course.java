package school.courses;

import school.courses.interfaces.CourseInterface;
import school.homework.Homework;
import school.people.Teacher;
import school.people.Student;
import java.util.ArrayList;
import java.util.List;

public class Course implements CourseInterface {
    private String courseName;
    private String courseCode;
    private Teacher teacher;
    private List<Student> students;
    private List<Homework> homeworks;

    public Course(String courseName, String courseCode, Teacher teacher) {
        setCourseName(courseName);
        setCourseCode(courseCode);
        setTeacher(teacher);
        this.students = new ArrayList<>();
        this.homeworks = new ArrayList<>();
    }

    @Override
    public String getCourseName() {
        return courseName;
    }

    @Override
    public void setCourseName(String courseName) {
        if (courseName == null || courseName.trim().isEmpty()) {
            throw new IllegalArgumentException("Course name cannot be null or empty.");
        }
        this.courseName = courseName;
    }

    @Override
    public String getCourseCode() {
        return courseCode;
    }

    @Override
    public void setCourseCode(String courseCode) {
        if (courseCode == null || courseCode.trim().isEmpty()) {
            throw new IllegalArgumentException("Course code cannot be null or empty.");
        }
        this.courseCode = courseCode;
    }

    @Override
    public Teacher getTeacher() {
        return teacher;
    }

    @Override
    public void setTeacher(Teacher teacher) {
        if (teacher == null) {
            throw new IllegalArgumentException("Teacher cannot be null.");
        }
        this.teacher = teacher;
    }

    @Override
    public List<Student> getStudents() {
        return students;
    }

    @Override
    public void addStudent(Student student) {

        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null.");
        }
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    @Override
    public void removeStudent(Student student) {
        students.remove(student);
    }

    @Override
    public List<Homework> getHomeworks() {
        return homeworks;
    }

    @Override
    public void addHomework(Homework homework) {
        // Валидация на домашната работа
        if (homework == null) {
            throw new IllegalArgumentException("Homework cannot be null.");
        }
        if (!homeworks.contains(homework)) {
            homeworks.add(homework);
        }
    }

    @Override
    public void removeHomework(Homework homework) {
        homeworks.remove(homework);
    }

}
