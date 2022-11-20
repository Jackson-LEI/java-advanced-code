package com.lanqiaobeiTraining.train;

import java.util.Scanner;

public class IdNumberUpdate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();

        StringBuilder front = new StringBuilder(s.substring(0, 6));
        StringBuilder back = new StringBuilder(s.substring(6));
        StringBuilder plusYear = new StringBuilder(front.append("19").append(back));

        int sum = 0;
        char m = 0;
        for (int i = 0; i < plusYear.length(); i++) {
            int value = Integer.parseInt(String.valueOf(plusYear.charAt(i)));
            switch (i) {
                case 0:
                case 10:
                    sum = sum + value * 7;
                    break;
                case 1:
                case 11:
                    sum = sum + value * 9;
                    break;
                case 2:
                case 12:
                    sum = sum + value * 10;
                    break;
                case 3:
                case 13:
                    sum = sum + value * 5;
                    break;
                case 4:
                case 14:
                    sum = sum + value * 8;
                    break;
                case 5:
                case 15:
                    sum = sum + value * 4;
                    break;
                case 6:
                case 16:
                    sum = sum + value * 2;
                    break;
                case 7:
                    sum = sum + value;
                    break;
                case 8:
                    sum = sum + value * 6;
                    break;
                case 9:
                    sum = sum + value * 3;
                    break;
            }
        }
        int z = sum % 11;
        switch (z) {

            case 0:
                m = '1';
                break;
            case 1:
                m = '0';
                break;
            case 2:
                m = 'x';
                break;
            case 3:
                m = '9';
                break;
            case 4:
                m = '8';
                break;
            case 5:
                m = '7';
                break;
            case 6:
                m = '6';
                break;
            case 7:
                m = '5';
                break;
            case 8:
                m = '4';
                break;
            case 9:
                m = '3';
                break;
            case 10:
                m = '2';
                break;
        }

        System.out.println(plusYear.append(m));
    }

}