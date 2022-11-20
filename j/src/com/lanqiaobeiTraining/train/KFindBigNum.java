package com.lanqiaobeiTraining.train;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class KFindBigNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        while (n > 0) {
            arr.add(sc.nextInt());
            n--;
        }

        int find = sc.nextInt();
        ArrayList<Integer> sub = new ArrayList<>();
        while (find > 0) {
            int left = sc.nextInt() - 1;
            int right = sc.nextInt() - 1;
            int k = sc.nextInt() - 1;
            for (; left <= right; left++) {
                sub.add(arr.get(left));
            }
            sub.sort(Collections.reverseOrder());
            System.out.println(sub.get(k));
            sub.clear();
            find--;
        }
        sc.close();
    }
}
