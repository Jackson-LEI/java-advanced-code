package practice.start;

import java.util.Scanner;

public class CalcAsset {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n = sc.nextDouble();
        double r = sc.nextDouble();
        sc.close();

        double asset = 200;
        double sum1;
        for (int i = 1; i <= 20; i++) {
            sum1 = n * i;
            asset = asset * (r / 100.0 + 1);
            if (sum1 >= asset) {
                System.out.print(i);
                return;
            }
        }
        System.out.println("Impossible");
    }

}
