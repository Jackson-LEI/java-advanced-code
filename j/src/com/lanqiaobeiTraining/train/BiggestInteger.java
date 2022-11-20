package com.lanqiaobeiTraining.train;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BiggestInteger {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String[] arr = new String[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.next();
        }
        sc.close();

        Arrays.sort(arr, Collections.reverseOrder());
        for (String x : arr) {
            System.out.print(x);
        }
    }

}
