package practice;

import java.util.Scanner;

public class Composing {
    // https://pintia.cn/problem-sets/994805046380707840/problems/994805091888906240
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        sc.close();

        int column = s.length() % n == 0 ? (s.length() / n) : (s.length() / n + 1);
        String[][] c = new String[n][column];
        int count = 0;
        for (int i = column - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                c[j][i] = String.valueOf(s.charAt(count));
                if (count == s.length() - 1) {
                    break;
                }
                count++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < column; j++) {
                if (c[i][j] != null) {
                    System.out.print(c[i][j]);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}