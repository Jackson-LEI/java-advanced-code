package practice;

import java.util.Scanner;

public class IntSum {
    // https://pintia.cn/problem-sets/994805046380707840/problems/994805135224455168
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();

        int size;
        if (a >= 0) {
            size = b - a + 1;
        } else {
            size = -a + b + 1;
        }

        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = a;
            a++;
        }

        for (int i = 0; i < arr.length; i++) {
            if (i % 5 == 0 && i != 0) {
                System.out.println();
                System.out.printf("%5d", arr[i]);
            } else {
                System.out.printf("%5d", arr[i]);
            }
        }
        System.out.println();

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }

        System.out.print("Sum = " + sum);
    }

}
