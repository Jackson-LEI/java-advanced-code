package com.lanqiaobeiTraining.train;

import java.util.Scanner;

public class ChangeString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        sc.close();

        int count = 0;
        int k = s.length();
        int i = t.length();
        while (k > 0) {
            if (s.charAt(i - 1) == t.charAt(k - 1)) {
                i--;
                k--;
            } else {
                k--;
                count++;
            }
            System.out.print(k);
        }
        System.out.print(count);
    }

}