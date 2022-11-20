package com.lanqiaobeiTraining.week2;

import java.util.Scanner;

public class MultipleSum {

    public static int fun(int n) {
        // ½×³ËÇóºÍ
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int count = 1;
            for (int j = 1; j <= i; j++) {
                count = (count * j) % 10000000;
            }
            sum = (sum + count) % 1000000;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        System.out.print(fun(n));
    }
}
