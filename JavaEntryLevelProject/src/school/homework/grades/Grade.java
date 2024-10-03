package school.homework.grades;

import school.homework.grades.interfaces.GradeInterface;
import school.homework.Homework;
import school.people.Student;

public class Grade implements GradeInterface {
    private Student student;
    private Homework homework;
    private double score;

    public Grade(Student student, Homework homework, double score) {
        setStudent(student);
        setHomework(homework);
        setScore(score);
    }

    @Override
    public Student getStudent() {
        return student;
    }

    @Override
    public void setStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null.");
        }
        this.student = student;
    }

    @Override
    public Homework getHomework() {
        return homework;
    }

    @Override
    public void setHomework(Homework homework) {
        if (homework == null) {
            throw new IllegalArgumentException("Homework cannot be null.");
        }
        this.homework = homework;
    }

    @Override
    public double getScore() {
        return score;
    }

    @Override
    public void setScore(double score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Score must be between 0 and 100.");
        }
        this.score = score;
    }
}
