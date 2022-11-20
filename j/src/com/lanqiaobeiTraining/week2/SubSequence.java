package com.lanqiaobeiTraining.week2;

import java.util.Scanner;

public class SubSequence {

    public static void main(String[] args) {
        // 子序列求和
        Scanner sc = new Scanner(System.in);
        int a = 1;
        int n = sc.nextInt();
        int m = sc.nextInt();
        while (n != 0 || m != 0) {
            double sum = 0;
            for (int i = n; i <= m; i++) {
                sum += 1.0 / (i * i);
            }
            System.out.printf("Case%d:%.5f\n", a++, sum);
            n = sc.nextInt();
            m = sc.nextInt();
        }
        sc.close();
    }

}
