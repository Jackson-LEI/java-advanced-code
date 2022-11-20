package com.lanqiaobeiTraining.train;

import java.util.Scanner;

public class Square {

    public static void main(String[] args) {
        int[][] arr = new int[5][5];
        arr[1][2] = 2;
        arr[2][1] = 4;
        arr[2][2] = 1;
        arr[2][3] = 3;
        arr[2][4] = 6;
        arr[3][2] = 5;
        arr[4][2] = 6;
        int t = 0, temp;
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'F') {
                temp = arr[1][2];
                arr[1][2] = arr[2][2];
                arr[2][2] = arr[3][2];
                arr[3][2] = arr[4][2];
                arr[4][2] = temp;
                arr[2][4] = arr[4][2];
            }
            if (s.charAt(i) == 'B') {
                temp = arr[4][2];
                arr[4][2] = arr[3][2];
                arr[3][2] = arr[2][2];
                arr[2][2] = arr[1][2];
                arr[1][2] = temp;
                arr[2][4] = arr[4][2];
            }
            if (s.charAt(i) == 'L') {
                temp = arr[2][1];
                arr[2][1] = arr[2][2];
                arr[2][2] = arr[2][3];
                arr[2][3] = arr[2][4];
                arr[2][4] = temp;
                arr[4][2] = arr[2][4];
            }
            if (s.charAt(i) == 'R') {
                temp = arr[2][4];
                arr[2][4] = arr[2][3];
                arr[2][3] = arr[2][2];
                arr[2][2] = arr[2][1];
                arr[2][1] = temp;
                arr[4][2] = arr[2][4];
            }
        }
        System.out.println(arr[2][2]);
        System.out.println(arr[2][4]);
        System.out.println(arr[2][1]);
        System.out.println(arr[2][3]);
        System.out.println(arr[1][2]);
        System.out.println(arr[3][2]);
    }
}
