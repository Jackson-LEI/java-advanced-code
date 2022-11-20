package com.lanqiaobeiTraining.train;

import java.util.Scanner;

public class StringStatis {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();

        int countNum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                countNum++;
            }
        }
        int first = s.indexOf("e");
        int last = s.lastIndexOf("g");
        if (s.contains("e") && s.contains("g") && first < last) {
            System.out.print(countNum + " " + (last - first - 1));
        } else {
            System.out.print(countNum + " " + 0);
        }

    }

}
