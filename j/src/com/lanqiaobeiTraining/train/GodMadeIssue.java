package com.lanqiaobeiTraining.train;

import java.util.Arrays;
import java.util.Scanner;

public class GodMadeIssue {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int find = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        while (find > 0) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            if (from == to) {
                System.out.println(arr[from]);
                find--;
                continue;
            }
            int[] temp = new int[to - from + 1];
            System.arraycopy(arr, from, temp, 0, to - from + 1);
            Arrays.sort(temp);
            System.out.println(temp[0]);
            find--;
        }
        sc.close();

    }

}
