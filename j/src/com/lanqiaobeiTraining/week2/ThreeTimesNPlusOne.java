package com.lanqiaobeiTraining.week2;

import java.util.Scanner;

public class ThreeTimesNPlusOne {

    public static void main(String[] args) {
        // 3n+1Œ Ã‚
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        while (n != 1) {
            if (n % 2 == 1) {
                n = n * 3 + 1;
            } else {
                n = n / 2;
            }
            count++;
        }
        sc.close();
        System.out.print(count);

    }

}
