package practice;

import java.util.Scanner;

public class ReadNumber {
    //https://pintia.cn/problem-sets/994805046380707840/problems/994805136889593856
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();

        for (int i = 0; i < s.length(); i++) {
            if (i != s.length() - 1) {
                switch (s.charAt(i)) {
                    case '1' -> System.out.print("yi ");
                    case '2' -> System.out.print("er ");
                    case '3' -> System.out.print("san ");
                    case '4' -> System.out.print("si ");
                    case '5' -> System.out.print("wu ");
                    case '6' -> System.out.print("liu ");
                    case '7' -> System.out.print("qi ");
                    case '8' -> System.out.print("ba ");
                    case '9' -> System.out.print("jiu ");
                    case '0' -> System.out.print("ling ");
                    case '-' -> System.out.print("fu ");
                }
            }
            if (i == s.length() - 1) {
                switch (s.charAt(i)) {
                    case '1' -> System.out.print("yi");
                    case '2' -> System.out.print("er");
                    case '3' -> System.out.print("san");
                    case '4' -> System.out.print("si");
                    case '5' -> System.out.print("wu");
                    case '6' -> System.out.print("liu");
                    case '7' -> System.out.print("qi");
                    case '8' -> System.out.print("ba");
                    case '9' -> System.out.print("jiu");
                    case '0' -> System.out.print("ling");
                    case '-' -> System.out.print("fu");
                }
            }

        }
    }

}
