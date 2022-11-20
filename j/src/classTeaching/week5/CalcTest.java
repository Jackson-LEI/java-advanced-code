package classTeaching.week5;

public class CalcTest {

    public static void main(String[] args) {
        Calculate c1 = new Cumulative();
        System.out.println("Cumulative:" + c1.calculate(4));
        Calculate c2 = new Factorial();
        System.out.println("Factorial:" + c2.calculate(4));
        Calculate c3 = (n) -> n * n;// ³Ë2
        System.out.println(c3.calculate(4));
        Calculate c4 = (n) -> n * 100;// À©´ó100±¶
        System.out.println(c4.calculate(1));
    }
}
