package com.lanqiaobeiTraining.train;

import java.util.Arrays;
import java.util.Scanner;

public class KthNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        while (m > 0) {
            int l = sc.nextInt() - 1;
            int r = sc.nextInt() - 1;
            int k = sc.nextInt() - 1;
            if (l == r) {
                System.out.println(arr[l]);
                m--;
                continue;
            }
            int[] temp = new int[r - l + 1];
            int index = 0;
            while (l <= r) {
                temp[index] = arr[l];
                index++;
                l++;
            }
            Arrays.sort(temp);
            System.out.println(temp[k]);
            m--;
        }
        sc.close();
    }
}
