package constants;

public class GlobalConstants {
    private static int nextUserId = 1;
    private static int nextCourseId = 1;
    private static int nextHomeworkId = 1;
    private static int nextStudentId = 1;

    public static int generateUserId() {
        return nextUserId++;
    }

    public static int generateCourseId() {
        return nextCourseId++;
    }

    public static int generateHomeworkId() {
        return nextHomeworkId++;
    }

    public static String generateStudentId() {
        return "S" + nextStudentId++;
    }
}
