package com.lanqiaobeiTraining.week1;

import java.util.Scanner;

public class SeriesSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        sc.close();
        int sum1 = 0;
        for (int i = 0; i <= c; i++) {
            sum1 = sum1 + i;
        }
        System.out.print(sum1);
    }

}
