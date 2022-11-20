package com.lanqiaobeiTraining.train;

import java.util.Scanner;

public class StringMatch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String match = sc.nextLine();
        int casePattern = sc.nextInt();
        int n = sc.nextInt();

        sc.nextLine();
        while (n > 0) {
            String line = sc.nextLine();
            if (casePattern == 0) {
                String ignoreCaseLine = line.toLowerCase();
                String ignoreCaseMatch = match.toLowerCase();
                if (ignoreCaseLine.contains(ignoreCaseMatch)) {
                    System.out.println(line);
                }
            } else {
                if (line.contains(match)) {
                    System.out.println(line);
                }
            }
            n--;
        }
        sc.close();
    }

}
