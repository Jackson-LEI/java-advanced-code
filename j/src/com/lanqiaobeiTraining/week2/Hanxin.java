package com.lanqiaobeiTraining.week2;

import java.util.Scanner;

public class Hanxin {

    public static void main(String[] args) {
        // º«ÐÅµã±ø
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            int flag = 0;
            for (int i = 10; i <= 100; i++) {
                if (i % 3 == a && i % 5 == b && i % 7 == c) {
                    System.out.println(i);
                    flag++;
                    break;
                }
            }
            if (flag == 0) {
                System.out.println("No answer!");
            }
        }
        sc.close();
    }
}
