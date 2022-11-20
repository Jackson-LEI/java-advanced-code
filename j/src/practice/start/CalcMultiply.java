package practice.start;

import java.util.Scanner;

public class CalcMultiply {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        int n = sc.nextInt();
        sc.close();

        for (int i = 0; i < n; i++) {
            x = x + (x * 0.001);
        }

        System.out.printf("%.4f", x);

    }

}