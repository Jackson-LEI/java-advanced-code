package classTeaching.week4;

public class TeamLeader {
    private double monthlyBonusAmount;
    private int requiredTrainingHours;
    private int teamLeaderTrainingHours;

    public TeamLeader() {

    }

    public TeamLeader(double monthlyBonusAmount, int requiredTrainingHours, int teamLeaderTrainingHours) {
        this.monthlyBonusAmount = monthlyBonusAmount;
        this.requiredTrainingHours = requiredTrainingHours;
        this.teamLeaderTrainingHours = teamLeaderTrainingHours;
    }

    public double getMonthlyBonusAmount() {
        return monthlyBonusAmount;
    }

    public void setMonthlyBonusAmount(double monthlyBonusAmount) {
        this.monthlyBonusAmount = monthlyBonusAmount;
    }

    public int getRequiredTrainingHours() {
        return requiredTrainingHours;
    }

    public void setRequiredTrainingHours(int requiredTrainingHours) {
        this.requiredTrainingHours = requiredTrainingHours;
    }

    public int getTeamLeaderTrainingHours() {
        return teamLeaderTrainingHours;
    }

    public void setTeamLeaderTrainingHours(int teamLeaderTrainingHours) {
        this.teamLeaderTrainingHours = teamLeaderTrainingHours;
    }

    @Override
    public String toString() {
        return "ÿ�½�����:" + monthlyBonusAmount + ",�������ѵʱ��:" + requiredTrainingHours + ", �ŶӸ������Ѳμӵ���ѵʱ��"
                + teamLeaderTrainingHours;
    }
}
