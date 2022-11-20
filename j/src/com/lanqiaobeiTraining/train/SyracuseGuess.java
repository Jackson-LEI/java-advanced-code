package com.lanqiaobeiTraining.train;

import java.util.Scanner;

public class SyracuseGuess {
    // https://acm.njupt.edu.cn/problem/NOJ1055/editor

    static int count = 0;

    public static void compete(int n) {
        if (n == 1) {
        } else {
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
        int a = sc.nextInt();
        int[] n = new int[a];
        for (int i = 0; i < n.length; i++) {
            n[i] = sc.nextInt();
        }
        sc.close();

        for (int i = 0; i < n.length; i++) {
            compete(n[i]);
            if (count % 2 == 0 || count == 1) {
                System.out.println("I win!");
            } else {
                System.out.println("I lost!");
            }
            count = 0;
        }
    }
}
