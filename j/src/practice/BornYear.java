package practice;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.TreeSet;

public class BornYear {
    // https://pintia.cn/problem-sets/994805046380707840/problems/994805099426070528
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        int n = sc.nextInt();
        sc.close();

        int bornYear = year;
        DecimalFormat df = new DecimalFormat("0000");
        TreeSet<Character> ts = new TreeSet<>();
        int count = 0;
        while (true) {
            String s = df.format(year);
            for (int i = 0; i < s.length(); i++) {
                if (ts.add(s.charAt(i))) {
                    count++;
                }
            }
            if (count == n) {
                break;
            }
            year++;
            count = 0;
            ts.clear();
        }

        int old = year - bornYear;
        System.out.println(old + " " + df.format(year));
    }
}
