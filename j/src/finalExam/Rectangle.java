package finalExam;

public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(){

    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.height = length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getPerimeter() {
        return (width + height) * 2;
    }

    @Override
    public double getArea() {
        return width * height;
    }
}
