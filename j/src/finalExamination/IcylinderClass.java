package finalExamination;

import java.text.DecimalFormat;

public class IcylinderClass {

    public static void main(String[] args) {
        Icylinder c = new Icylinder(3, 7);
        DecimalFormat df = new DecimalFormat();
        df.applyLocalizedPattern("0.00");
        System.out.print("�뾶��" + c.radius + "���ߣ�" + c.height + "�������" + df.format(c.getVolume()));
    }

}