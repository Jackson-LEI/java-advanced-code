package com.lanqiaobeiTraining.train;

import java.util.Scanner;
import java.util.TreeSet;

public class CalcCollection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();

        TreeSet<Integer> set1 = new TreeSet<>();
        while (first > 0) {
            set1.add(sc.nextInt());
            first--;
        }

        int second = sc.nextInt();
        TreeSet<Integer> set2 = new TreeSet<>();
        while (second > 0) {
            set2.add(sc.nextInt());
            second--;
        }
        sc.close();

        TreeSet<Integer> result1 = new TreeSet<>();
        TreeSet<Integer> result2 = new TreeSet<>();
        for (int x : set1) {
            if (!set2.add(x)) {
                result1.add(x);
            } else {
                result2.add(x);
            }
        }

        if (!result1.isEmpty()) {
            for (int x : result1) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        if (!set2.isEmpty()) {
            for (int x : set2) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        if (!result2.isEmpty()) {
            for (int x : result2) {
                System.out.print(x + " ");
            }
        }
    }
}
