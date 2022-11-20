package com.lanqiaobeiTraining.train;

import java.util.ArrayList;
import java.util.Scanner;

public class RealFactor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);//IPO
        int n = sc.nextInt();
        sc.close();

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                list.add(i);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.contains(1)) {
                list.remove(list.indexOf(1));
            }
            boolean isPrime = true;
            for (int j = 2; j < list.get(i); j++) {
                if (list.get(i) % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                ans.add(list.get(i));
            }
        }
        if (!ans.contains(2) && !ans.contains(3) && !ans.contains(5)) {
            System.out.print("No");
        } else {
            for (int i = 0; i < ans.size(); i++) {
                if (ans.get(i) != 2) {

                }
            }
        }

    }

}
