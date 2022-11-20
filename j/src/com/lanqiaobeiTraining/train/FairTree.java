package com.lanqiaobeiTraining.train;

import java.time.LocalDate;
import java.util.Scanner;

public class FairTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        int h = sc.nextInt();
        sc.close();

        int count = 0;
        while (year < 2013) {
            LocalDate l = LocalDate.of(year, 1, 1);
            if (l.isLeapYear()) {
                count += 366;
            } else {
                count += 365;
            }
            year++;
        }
        System.out.println(h + count);
    }
}
