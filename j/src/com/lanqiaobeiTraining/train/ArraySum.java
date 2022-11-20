package com.lanqiaobeiTraining.train;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ArraySum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int find = sc.nextInt();

        int[] arr = new int[n * 2];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.arraycopy(arr, 0, arr, n, n);
        sc.close();

        int sum = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < find; j++) {
                sum += arr[j + i];
            }
            list.add(sum);
            sum = 0;
        }
        System.out.print(Collections.max(list));
    }

}
