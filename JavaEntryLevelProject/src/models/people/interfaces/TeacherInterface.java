package models.people.interfaces;

public interface TeacherInterface extends PersonInterface {
    String getSubject();
    void setSubject(String subject);
}