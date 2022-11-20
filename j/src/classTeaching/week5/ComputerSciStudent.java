package classTeaching.week5;

public class ComputerSciStudent extends Student {
    public static final int MATH_HOURS = 20;
    public static final int COMPUTER_HOURS = 40;
    public static final int GENERAL_HOURS = 60;

    private int mathHours;
    private int computerHours;
    private int generalHours;

    public ComputerSciStudent() {

    }

    public ComputerSciStudent(String studentName, String studentId, int enrolledYear, int mathHours, int computerHours,
                              int generalHours) {
        super(studentName, studentId, enrolledYear);
        this.mathHours = mathHours;
        this.computerHours = computerHours;
        this.generalHours = generalHours;
    }

    public void setMathHours(int mathHours) {
        this.mathHours = mathHours;
    }

    public void setComputerHours(int computerHours) {
        this.computerHours = computerHours;
    }

    public void setGeneralHours(int generalHours) {
        this.generalHours = generalHours;
    }

    @Override
    public int getRemainingHours() {
        return MATH_HOURS + COMPUTER_HOURS + GENERAL_HOURS - this.computerHours - this.generalHours - this.mathHours;
    }

    @Override
    public String toString() {
        return super.toString() + ",数学:" + this.mathHours + ",计算机科学:" + this.computerHours + ",一般学科:"
                + this.generalHours + ",剩余学时:" + this.getRemainingHours();
    }

}
