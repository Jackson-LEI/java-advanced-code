package practice;

import java.util.ArrayList;
import java.util.Scanner;

public class KnockStupidClock {
    // https://pintia.cn/problem-sets/994805046380707840/problems/1111914599412858880
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        boolean isRhymed = false;
        ArrayList<StringBuffer> list = new ArrayList<>();
        StringBuilder ans = new StringBuilder();
        while (n > 0) {
            String s = sc.nextLine();
            if (s.startsWith("ong", s.indexOf(",") - 3)) {
                if (s.startsWith("ong", s.indexOf(".") - 3)) {
                    isRhymed = true;
                    list.add(replaceString(s));
                }
            }
            if (!isRhymed) {
                list.add(new StringBuffer("Skipped"));
            }
            n--;
            isRhymed = false;
        }
        for (StringBuffer bf : list) {
            System.out.println(bf);
        }
        sc.close();
    }

    private static StringBuffer replaceString(String s) {
        String[] temp = s.split(" ");
        temp[temp.length - 3] = "qiao";
        temp[temp.length - 2] = "ben";
        temp[temp.length - 1] = "zhong.";

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < temp.length; i++) {
            if (i == temp.length - 1) {
                sb.append(temp[i]);
            } else {
                sb.append(temp[i]).append(" ");
            }
        }
        return sb;
    }

}
