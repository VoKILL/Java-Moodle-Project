

import school.people.Student;
import school.people.Teacher;
import school.courses.Course;
import school.homework.Homework;
import school.homework.grades.Grade;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        try {
            // Създаване на учител
            Teacher teacher = new Teacher("Alice Johnson", 35, "Mathematics");

            // Създаване на курс
            Course course = new Course("Algebra", "MATH101", teacher);

            // Създаване на ученици
            Student student1 = new Student("John Doe", 16, "S001");
            Student student2 = new Student("Jane Smith", 17, "S002");

            // Добавяне на ученици към курса
            course.addStudent(student1);
            course.addStudent(student2);

            // Създаване на домашна работа
            Date dueDate = new Date(System.currentTimeMillis() + 86400000); // Краен срок след 1 ден
            Homework homework = new Homework("Homework 1", "Solve equations", dueDate);

            // Добавяне на домашната работа към курса
            course.addHomework(homework);

            // Създаване на оценки
            Grade grade1 = new Grade(student1, homework, 85.5);
            Grade grade2 = new Grade(student2, homework, 92.0);

            // Добавяне на оценки към домашната работа
            homework.addGrade(grade1);
            homework.addGrade(grade2);

            // Добавяне на оценки към учениците
            student1.addGrade(grade1);
            student2.addGrade(grade2);

            // Извеждане на информация за курса
            System.out.println("Course: " + course.getCourseName());
            System.out.println("Teacher: " + course.getTeacher().getName());
            System.out.println("Students:");
            for (Student s : course.getStudents()) {
                System.out.println("- " + s.getName() + " (ID: " + s.getStudentId() + ")");
            }

            // Извеждане на информация за домашните и оценките
            System.out.println("Homework Assignments:");
            for (Homework hw : course.getHomeworks()) {
                System.out.println("- " + hw.getTitle() + " (Due: " + hw.getDueDate() + ")");
                System.out.println("  Grades:");
                for (Grade gr : hw.getGrades()) {
                    System.out.println("    Student: " + gr.getStudent().getName() + ", Score: " + gr.getScore());
                }
            }

            // Извеждане на оценките на учениците
            System.out.println("Student Grades:");
            for (Student s : course.getStudents()) {
                System.out.println("- " + s.getName() + "'s Grades:");
                for (Grade gr : s.getGrades()) {
                    System.out.println("  Homework: " + gr.getHomework().getTitle() + ", Score: " + gr.getScore());
                }
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
