package practice.start;

import java.util.Scanner;

public class Output {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        int num = 1;
        int lim = n + 1;
        int[][] arr = new int[n][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < lim - 1; j++) {
                arr[i][j] = num;
                num++;
                if (j == j - lim) {
                    break;
                }
            }
            lim--;
        }

        int stuff = n - 2;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = stuff;
                }
            }
            if (i != 0) {
                stuff = stuff * (n - 2);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }

    }
}
