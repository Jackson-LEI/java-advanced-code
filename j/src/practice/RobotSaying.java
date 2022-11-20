package practice;

import java.util.Scanner;

public class RobotSaying {
    // https://pintia.cn/problem-sets/994805046380707840/problems/1386335159927652355
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double sale = sc.nextInt();

        double[] ch = new double[n];

        for (int i = 0; i < ch.length; i++) {
            ch[i] = sc.nextDouble();
        }
        sc.close();

        for (int j = 0; j < ch.length; j++) {
            if (sale > ch[j]) {
                System.out.print("On Sale!" + ch[j] + "\r");
            }
        }
    }
}