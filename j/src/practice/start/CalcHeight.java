package practice.start;

import java.util.Scanner;

public class CalcHeight {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double height = sc.nextDouble();
        sc.close();

        double sum;
        double tenTimes = 0;
        double s = height;
        sum = s;
        for (int i = 0; i < 9; i++) {
            height = height / 2;
            sum = sum + s;
        }
        for (int i = 0; i < 9; i++) {
            tenTimes = height / 2;
        }
        System.out.println(sum);
        System.out.print(tenTimes);
    }

}
