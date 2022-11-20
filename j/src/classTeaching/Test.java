package classTeaching;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int length;
        if (s.length() % 6 != 0) {
            length = s.length() / 6 + 1;
        } else {
            length = s.length() / 6;
        }
        String[] arr = new String[length];

        int index = 0;
        for (int j = 0; j < s.length(); j += 6) {
            if (s.substring(j).length() >= 6) {
                arr[index] = s.substring(j, j + 6);
            } else {
                arr[index] = s.substring(j);
            }
            index++;
        }

        int[] ans = new int[6];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length(); j++) {
                ans[j] += arr[i].charAt(j);
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ans.length; i++) {
            String temp = String.valueOf(ans[i]);
            while (true) {
                int sum = 0;
                for (int j = 0; j < temp.length(); j++) {
                    sum += Integer.parseInt(String.valueOf(temp.charAt(j)));
                }
                if (sum >= 10) {
                    temp = String.valueOf(sum);
                } else {
                    sb.append(sum);
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
