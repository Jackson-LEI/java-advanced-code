package practice;

import java.util.Scanner;

public class SeatNumber {
    // https://pintia.cn/problem-sets/994805046380707840/problems/994805140211482624
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String[][] content = new String[n][3];

        for (int i = 0; i < content.length; i++) {
            for (int j = 0; j < content[i].length; j++) {
                content[i][j] = sc.next();
            }
        }

        int find = sc.nextInt();
        String[] num = new String[find];

        for (int i = 0; i < num.length; i++) {
            num[i] = sc.next();
            for (int j = 0; j < n; j++) {
                if (content[j][1].equals(num[i])) {
                    System.out.println(content[j][0] + " " + content[j][2]);
                }
            }
        }
        sc.close();
    }
}
