package practice;

import java.util.Scanner;

public class IdentifyId {
    // https://pintia.cn/problem-sets/994805046380707840/problems/994805122985476096
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int times = sc.nextInt();

        String[] s = new String[times];
        for (int i = 0; i < times; i++) {
            s[i] = sc.next();
        }
        sc.close();

        int sum = 0;
        char m = 0;
        boolean flag = false;
        int count = 0;
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[i].length() - 1; j++) {
                if (!Character.isDigit(s[i].charAt(j))) {
                    flag = true;
                    System.out.println(s[i]);
                } else {
                    int value = Integer.parseInt(String.valueOf(s[i].charAt(j)));
                    switch (j) {
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
                        m = 'X';
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
            }
            if (s[i].charAt(17) != m && !flag) {
                System.out.println(s[i]);
            } else {
                count++;
            }

            if (count == times) {
                System.out.println("All passed");
            }
            flag = false;
            sum = 0;
        }
    }
}