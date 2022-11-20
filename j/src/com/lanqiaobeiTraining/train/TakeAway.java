package com.lanqiaobeiTraining.train;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class TakeAway {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        Integer[] arr = new Integer[s.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(arr, Collections.reverseOrder());

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
