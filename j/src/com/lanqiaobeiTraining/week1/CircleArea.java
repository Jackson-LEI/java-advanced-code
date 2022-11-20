package com.lanqiaobeiTraining.week1;

import java.util.Scanner;

public class CircleArea {

    public static void main(String[] args) {
        final double PI = 3.14159265358979323;
        Scanner sc = new Scanner(System.in);
        int radius = sc.nextInt();
        sc.close();

        double area = PI * radius * radius;
        String s = String.format("%.7f", area);
        System.out.print(s);

    }

}
