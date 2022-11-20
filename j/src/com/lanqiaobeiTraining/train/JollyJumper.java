package com.lanqiaobeiTraining.train;

import java.util.ArrayList;
import java.util.Scanner;

public class JollyJumper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            a.add(Math.abs(arr[i] - arr[i + 1]));
        }

        boolean flag = false;
        for (int i = 0; i < a.size() - 1; i++) {
            flag = a.get(i) == a.get(i + 1) + 1;
        }

        if (flag) {
            System.out.println("Jolly");
        } else {
            System.out.println("Not Jolly");
        }
    }
}
