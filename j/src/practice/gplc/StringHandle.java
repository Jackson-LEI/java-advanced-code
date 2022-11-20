package practice.gplc;

import java.util.Scanner;

public class StringHandle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        sc.close();

        StringBuffer bf1 = new StringBuffer();
        for (int i = 1; i < a.length(); i++) {
            int parseInt = Integer.parseInt(String.valueOf(a.charAt(i)));
            int anInt = Integer.parseInt(String.valueOf(a.charAt(i - 1)));
            if (parseInt % 2 == anInt % 2) {
                bf1.append(Math.max(parseInt, anInt));
            }
        }
        StringBuffer bf2 = new StringBuffer();
        for (int i = 1; i < b.length(); i++) {
            int parseInt = Integer.parseInt(String.valueOf(b.charAt(i)));
            int anInt = Integer.parseInt(String.valueOf(b.charAt(i - 1)));
            if (parseInt % 2 == anInt % 2) {
                bf2.append(Math.max(parseInt, anInt));
            }
        }
        if (new String(bf1).equals(new String(bf2))) {
            System.out.println(bf1);
        } else {
            System.out.println(bf1);
            System.out.println(bf2);
        }

    }
}
