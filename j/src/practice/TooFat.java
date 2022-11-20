package practice;

import java.util.Scanner;

public class TooFat {
    // https://pintia.cn/problem-sets/994805046380707840/problems/994805102173339648
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while (n > 0) {
            double height = sc.nextInt();
            double weight = sc.nextInt();

            double standardWeight = (height - 100) * 0.9;
            if ((Math.abs(standardWeight - (weight / 2.0))) < (standardWeight * 0.1)) {
                System.out.println("You are wan mei!");
            } else if ((standardWeight - (weight / 2.0)) < 0) {
                System.out.println("You are tai pang le!");
            } else {
                System.out.println("You are tai shou le!");
            }
            n--;
        }
        sc.close();
    }
}
