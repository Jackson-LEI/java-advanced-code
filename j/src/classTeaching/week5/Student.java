package classTeaching.week5;

public abstract class Student {
    private String studentName;
    private String studentId;
    private int enrolledYear;

    public Student() {

    }

    public Student(String studentName, String studentId, int enrolledYear) {
        this.studentName = studentName;
        this.studentId = studentId;
        this.enrolledYear = enrolledYear;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getEnrolledYear() {
        return enrolledYear;
    }

    public void setEnrolledYear(int enrolledYear) {
        this.enrolledYear = enrolledYear;
    }

    @Override
    public String toString() {
        return "ѧ������:" + this.studentName + ",ѧ��ѧ��:" + this.studentId + ",��ѧ���:" + this.enrolledYear;
    }

    public abstract int getRemainingHours();
}
