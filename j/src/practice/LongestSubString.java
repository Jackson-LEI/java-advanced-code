package practice;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class LongestSubString {
    //https://pintia.cn/problem-sets/994805046380707840/problems/994805067704549376
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();

        int count = 0;
        int index = 1;
        TreeSet<String> set = new TreeSet<>(new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        for (int i = 0; i < s.length(); i++) {
            for (int j = index; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                StringBuilder bf = new StringBuilder(sub);
                String reverse = new String(bf.reverse());
                if (sub.equals(reverse)) {
                    set.add(new String(bf));
                }
            }
            index++;
        }
        System.out.println(set.last().length());
    }
}
