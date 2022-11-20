package practice;

import java.util.Scanner;

public class WhoDrunkFirst {
    // https://pintia.cn/problem-sets/994805046380707840/problems/994805118568873984
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int n = sc.nextInt();
        int[] arr = new int[4];
        int recordA = 0;
        int recordB = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[j] = sc.nextInt();
            }
            boolean b1 = arr[0] + arr[2] == arr[3];
            boolean b2 = arr[0] + arr[2] == arr[1];
            if (b2 && b1) {
                continue;
            }
            if (b2) {
                a--;
                recordA++;
            }
            if (b1) {
                b--;
                recordB++;
            }
            if (a < 0) {
                System.out.println("A");
                System.out.println(recordB);
                return;
            }
            if (b < 0) {
                System.out.println("B");
                System.out.println(recordA);
                return;
            }
        }
        sc.close();
    }
}