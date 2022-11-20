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
        return "每月奖金金额:" + monthlyBonusAmount + ",所需的培训时数:" + requiredTrainingHours + ", 团队负责人已参加的培训时数"
                + teamLeaderTrainingHours;
    }
}
