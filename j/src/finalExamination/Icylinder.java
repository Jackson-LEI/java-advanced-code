package finalExamination;

@SuppressWarnings("CanBeFinal")
public class Icylinder {
    double radius;
    double height;

    public Icylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    public double getVolume() {
        return Math.PI * radius * radius * height;
    }

}
