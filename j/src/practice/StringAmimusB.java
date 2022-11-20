package practice;

import java.util.Scanner;

public class StringAmimusB {
    // https://pintia.cn/problem-sets/994805046380707840/problems/994805130426171392
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String d = sc.nextLine();
        sc.close();

        char[] ch = new char[s.length()];
        int index = 0;
        for (int i = 0; i < d.length(); i++) {
            char c = d.charAt(i);
            for (int j = 0; j < s.length(); j++) {
                if (c != s.charAt(j)) {
                    ch[index++] = s.charAt(j);
                }
            }
            s = new String(ch, 0, index);
            index = 0;
        }

        System.out.print(s);

    }
}