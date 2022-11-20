package practice;

import java.util.Scanner;

public class LeftPad {
    // https://pintia.cn/problem-sets/994805046380707840/problems/994805100684361728
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        String ch = sc.next();
        sc.nextLine();
        StringBuffer s = new StringBuffer(sc.nextLine());
        sc.close();

        if (s.length() == length) {
            System.out.println(s);
        } else if (s.length() > length) {
            StringBuffer sb = new StringBuffer(s);
            sb.delete(0, s.length() - length);
            System.out.println(sb);
        } else {
            int append = length - s.length();
            StringBuilder letter = new StringBuilder();
            letter.append(String.valueOf(ch).repeat(Math.max(0, append)));
//            StringBuffer result = letter.append(s);
//            System.out.println(result);
        }
    }
}
