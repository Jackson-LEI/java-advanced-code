package practice;

import java.util.Scanner;

public class WhoIsWinner {
    // https://pintia.cn/problem-sets/994805046380707840/problems/994805075543703552
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int[] arr = new int[3];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        int count0 = 0;
        int count1 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                count0++;
            } else {
                count1++;
            }
        }

        if (a > b) {
            boolean win = false;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0) {
                    win = true;
                    break;
                }
            }
            if (win) {
                System.out.println("The winner is a: " + a + " + " + count0);
            } else {
                System.out.println("The winner is b: " + b + " + " + count1);
            }
        }

        if (a < b) {
            boolean win = true;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0) {
                    win = false;
                    break;
                }
            }
            if (win) {
                System.out.println("The winner is b: " + b + " + " + count1);
            }
        }

    }
}