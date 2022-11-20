package practice;

import java.util.Scanner;

public class APlusB {
    // https://pintia.cn/problem-sets/994805046380707840/problems/994805110318678016
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        String a = s.substring(0, s.indexOf(" "));
        String b = s.substring(s.indexOf(" ") + 1);

        String answerA = null;
        String answerB = null;
        boolean flag1 = true;
        boolean flag2 = true;
        for (int i = 0; i < a.length(); i++) {
            if (!Character.isDigit(a.charAt(i))) {
                flag1 = false;
                answerA = "?";
                break;
            } else {
                answerA = a;
            }
        }

        for (int i = 0; i < b.length(); i++) {
            if (!Character.isDigit(b.charAt(i))) {
                flag2 = false;
                answerB = "?";
                break;
            } else {
                answerB = b;
            }
        }

        if (flag1 && flag2) {
            assert answerA != null;
            if (Integer.parseInt(answerA) > 1000 || Integer.parseInt(answerA) <= 0) {
                answerA = "?";
            }

            assert answerB != null;
            if (Integer.parseInt(answerB) > 1000 || Integer.parseInt(answerB) <= 0) {
                answerB = "?";
            }
        }
        String sum;
        if (answerA.equals("?") || answerB.equals("?")) {
            sum = "?";
        } else {
            sum = String.valueOf(Integer.parseInt(answerA) + Integer.parseInt(answerB));
        }

        System.out.println(answerA + " + " + answerB + " = " + sum);
    }
}
