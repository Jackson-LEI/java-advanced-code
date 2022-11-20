package classTeaching.week4;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Employee extends TeamLeader {
    // ˽�����Զ���
    private int ID;
    private String name;
    private double basicSalary;
    private double bonus;
    private String date;

    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��");
    private Calendar dateObject;

    public Employee() {

    }

    // �в������캯��ʵ���������Գ�ʼ��
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

    // ˽������ID��д����
    public void setID(int ID) { // ����ID��ֵ
        this.ID = ID;
    }

    public int getID() {// ����ID��ֵ
        return this.ID;
    }

    // �����������ԵĶ�д����
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

    // ��������˰
    public double getTax() {
        double tax = 0;
        if (this.basicSalary + this.bonus - 1600 > 0)
            tax = (this.basicSalary + this.bonus - 1600) * 0.15;
        return tax;
    }

    // ����ʵ�ʹ���
    public double getRealSalary() {
        double realSalary;
        // ���㲢����ʵ�ʹ���
        realSalary = this.basicSalary + this.bonus - this.getTax();
        return realSalary;
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat();
        df.applyLocalizedPattern("00000000");
        return "Ա������:" + getName() + ",����:" + df.format(getID()) + ",��������:" + getBasicSalary() +
                ",����" + getBonus() + ",Ƹ������:" + getDate() + ",����˰:" + getTax() + ",ʵ�ʹ���:" +
                getRealSalary();
    }
}
