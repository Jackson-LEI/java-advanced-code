package com.lanqiaobeiTraining.week3;

import java.util.Scanner;

public class EatFish {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        sc.close();

        long[] arr = new long[71];
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 2;
        for (int i = 4; i <= 70; i++) {
            arr[i] = arr[i - 3] + arr[i - 1];
        }
        System.out.print(arr[a]);
    }

}
