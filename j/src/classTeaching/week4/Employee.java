package classTeaching.week4;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Employee extends TeamLeader {
    // 私有属性定义
    private int ID;
    private String name;
    private double basicSalary;
    private double bonus;
    private String date;

    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
    private Calendar dateObject;

    public Employee() {

    }

    // 有参数构造函数实现所有属性初始化
    public Employee(int ID, String name, double basicSalary, double bonus, String date) {
        this.ID = ID;
        this.name = name;
        this.basicSalary = basicSalary;
        this.bonus = bonus;
        String[] s = date.split("-|.");
        dateObject.set(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]));
        this.date = sdf.format(dateObject);
    }

    public Employee(double monthlyBonusAmount, int requiredTrainingHours, int teamLeaderTrainingHours, int ID,
                    String name, double basicSalary, double bonus, String date) {
        super(monthlyBonusAmount, requiredTrainingHours, teamLeaderTrainingHours);
        this.ID = ID;
        this.name = name;
        this.basicSalary = basicSalary;
        this.bonus = bonus;
        this.date = date;
    }

    // 私有属性ID读写函数
    public void setID(int ID) { // 设置ID的值
        this.ID = ID;
    }

    public int getID() {// 返回ID的值
        return this.ID;
    }

    // 其它三个属性的都写函数
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getBasicSalary() {
        return this.basicSalary;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getBonus() {
        return this.bonus;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    // 计算所得税
    public double getTax() {
        double tax = 0;
        if (this.basicSalary + this.bonus - 1600 > 0)
            tax = (this.basicSalary + this.bonus - 1600) * 0.15;
        return tax;
    }

    // 计算实际工资
    public double getRealSalary() {
        double realSalary;
        // 计算并返回实际工资
        realSalary = this.basicSalary + this.bonus - this.getTax();
        return realSalary;
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat();
        df.applyLocalizedPattern("00000000");
        return "员工姓名:" + getName() + ",工号:" + df.format(getID()) + ",基本工资:" + getBasicSalary() +
                ",奖金" + getBonus() + ",聘用日期:" + getDate() + ",所得税:" + getTax() + ",实际工资:" +
                getRealSalary();
    }
}
