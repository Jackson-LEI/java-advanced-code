package com.lanqiaobeiTraining.train;

import java.util.Scanner;

public class SyracuseGuessCP {

    static int count = 0;

    public static void compete(int n) {
        if (n != 1) {
            if (n % 2 != 0) {
                compete(n * 3 + 1);
            } else {
                compete(n / 2);
            }
        }
        count++;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int times = sc.nextInt();
        while (times != 0) {
            int a = sc.nextInt();
            compete(a);
            if (count % 2 == 0 || count == 1) {
                System.out.println("I win!");
            } else {
                System.out.println("I lost!");
            }
            count = 0;
            times--;
        }
        sc.close();
    }
}
