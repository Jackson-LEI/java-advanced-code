package practice.start;

import java.util.Scanner;

public class CalcInterest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double r = sc.nextDouble();
        double m = sc.nextInt();
        int y = sc.nextInt();
        sc.close();

        double sum = 0;
        for (int i = 0; i < y; i++) {
            m = m + m * (r / 100);
            sum = (int) m;
        }
        System.out.printf("%.0f", sum);
    }

}
