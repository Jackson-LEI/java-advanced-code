package practice;

import java.util.Scanner;

public class FuReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char c = sc.next().charAt(0);
        int n = sc.nextInt();

        sc.nextLine();
        int index = 0;
        char[][] data = new char[n][n];
        while (index < n) {
            String temp = sc.nextLine();
            for (int i = 0; i < temp.length(); i++) {
                data[index][i] = temp.charAt(i);
            }
            index++;
        }
        sc.close();

        char[][] ans = new char[n][n];
        for (int i = data.length - 1, i1 = 0; i >= 0; i--, i1++) {
            for (int j = data[i].length - 1, j1 = 0; j >= 0; j--, j1++) {
                ans[i1][j1] = data[i][j];
            }
        }
        boolean isSame = true;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (ans[i][j] == ' ' && data[i][j] == ' ') {
                    continue;
                } else if (ans[i][j] != ' ' && data[i][j] != ' ') {
                    continue;
                } else {
                    isSame = false;
                    break;
                }
            }
        }
        if (isSame) {
            System.out.println("bu yong dao le");
        }
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans.length; j++) {
                if (ans[i][j] != ' ') {
                    System.out.print(c);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}