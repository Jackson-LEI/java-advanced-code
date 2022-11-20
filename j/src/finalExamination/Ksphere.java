package finalExamination;

import java.text.DecimalFormat;

@SuppressWarnings("CanBeFinal")
public class Ksphere {
    double radius;
    public static final double PI = 3.14;
    static final DecimalFormat df = new DecimalFormat("0.00");

    public Ksphere() {
        radius = 1;
    }

    public double setRadius(double radius) {
        if (radius < 0) {
            System.err.println("�뾶ֵ����С��0��");
            return radius;
        } else {
            return this.radius = radius;
        }
    }

    public double getArea() {
        return 4 * PI * radius * radius;
    }

    public double getVolume() {
        return 4.0 / 3 * PI * radius * radius * radius;
    }

    @Override
    public String toString() {
        return "�뾶��" + radius + "���������" + df.format(getArea()) + "�������" + df.format(getVolume());
    }

    public boolean equals(Ksphere s) {
        return this.radius == s.radius;
    }
}

