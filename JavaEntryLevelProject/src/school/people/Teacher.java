package school.people;

import school.people.interfaces.TeacherInterface;

public class Teacher implements TeacherInterface {
    private String name;
    private int age;
    private String subject;

    public Teacher(String name, int age, String subject) {
        setName(name);
        setAge(age);
        setSubject(subject);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        this.name = name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        if (age < 21 || age > 100) {
            throw new IllegalArgumentException("Age must be between 21 and 100.");
        }
        this.age = age;
    }

    @Override
    public String getSubject() {
        return subject;
    }

    @Override
    public void setSubject(String subject) {
        if (subject == null || subject.trim().isEmpty()) {
            throw new IllegalArgumentException("Subject cannot be null or empty.");
        }
        this.subject = subject;
    }
}
