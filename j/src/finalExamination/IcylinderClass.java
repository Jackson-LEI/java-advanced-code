package finalExamination;

import java.text.DecimalFormat;

public class IcylinderClass {

    public static void main(String[] args) {
        Icylinder c = new Icylinder(3, 7);
        DecimalFormat df = new DecimalFormat();
        df.applyLocalizedPattern("0.00");
        System.out.print("°ë¾¶£º" + c.radius + "£¬¸ß£º" + c.height + "£¬Ìå»ý£º" + df.format(c.getVolume()));
    }

}