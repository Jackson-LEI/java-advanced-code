package classTeaching.week4;

public class ProductionWorker extends Employee {
    private int shift;
    private double hourlyPayRate;

    public ProductionWorker() {

    }

    public ProductionWorker(int ID, String name, double basicSalary, double bonus, String date, int shift,
                            double hourlyPayRate) {
        super(ID, name, basicSalary, bonus, date);
        this.setShift(shift);
        this.sethourlyPayRate(hourlyPayRate);
    }

    public void setShift(int shift) {
        this.shift = shift;
    }

    public void sethourlyPayRate(double hourlyPayRate) {
        this.hourlyPayRate = hourlyPayRate;
    }

    public int getShift() {
        return this.shift;
    }

    public double getHourlyPayRate() {
        return this.hourlyPayRate;
    }

    public String toString() {
        return super.toString() + ",°à´Î:" + getShift() + ",Ê±Ð½:" + getHourlyPayRate();
    }
}
