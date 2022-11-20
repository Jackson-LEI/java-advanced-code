package classTeaching.week4;

public class Circle {
    private double radius;

    public Circle() {

    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * this.radius;
    }

    @Override
    public String toString() {
        return "半径：" + radius + ",周长:" + getPerimeter() + "面积:" + getPerimeter();
    }

    public boolean equals(Circle c) {
        return c.radius == this.radius;
    }

    public boolean greaterThan(Circle c) {
        return this.getArea() > c.getArea();
    }
}
