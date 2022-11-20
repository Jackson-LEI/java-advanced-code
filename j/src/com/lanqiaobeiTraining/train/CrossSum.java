package com.lanqiaobeiTraining.train;

import java.util.Scanner;

public class CrossSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long l = sc.nextLong();
        long r = sc.nextLong();
        int sum = sc.nextInt();
        sc.close();

        int count = 0;
        long result = 0;
        while (l < r) {
            String s = "0" + l;
            for (int i = 1; i < s.length(); i++) {
                int num = Integer.parseInt(String.valueOf(s.charAt(i)));
                if (i % 2 != 0) {
                    count = count + num;
                } else
                    count = count - num;
            }
            if (count == sum) {
                result = result + l;
            }
            count = 0;
            l++;
        }
        System.out.println(result % (long) (Math.pow(10, 9) + 7));
    }
}
