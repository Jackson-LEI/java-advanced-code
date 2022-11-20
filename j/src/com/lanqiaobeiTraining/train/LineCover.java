package com.lanqiaobeiTraining.train;

import java.util.HashSet;
import java.util.Scanner;

public class LineCover {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        HashSet<Integer> set = new HashSet<>();
        while (n > 0) {
            int from = sc.nextInt();
            int end = sc.nextInt();
            for (; from <= end; from++) {
                set.add(from);
            }
            n--;
        }
        sc.close();
        System.out.print(set.size());

    }

}
