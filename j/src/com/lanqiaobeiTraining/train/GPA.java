package com.lanqiaobeiTraining.train;

import java.util.Scanner;

public class GPA {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a1 = sc.nextInt();
        double suma1 = 0;
        int suma1Score = 0;
        boolean isDigit;
        while (a1 > 0) {
            int score = sc.nextInt();
            String perform = sc.next();
            if (perform.equals("N") || perform.equals("P")) {
                isDigit = false;
            } else {
                isDigit = true;
            }
            if (isDigit) {
                suma1 += score * Integer.parseInt(perform);
                suma1Score += score;
            }
            a1--;
        }
        double a1GPA = suma1 / suma1Score;

        int a2 = sc.nextInt();
        double suma2 = 0;
        int suma2Score = 0;
        while (a2 > 0) {
            int score = sc.nextInt();
            String perform = sc.next();
            if (perform.equals("N") || perform.equals("P")) {
                isDigit = false;
            } else {
                isDigit = true;
            }
            if (isDigit) {
                suma2 += score * Integer.parseInt(perform);
                suma2Score += score;
            }
            a2--;
        }
        sc.close();

        double a2GPA = suma2 / suma2Score;
        if (a1GPA - a2GPA > 1) {
            System.out.printf("%.2f\n", a1GPA - a2GPA);
        } else {
            System.out.println("0.00");
        }
    }
}
