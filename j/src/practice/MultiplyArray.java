package practice;

import java.util.ArrayList;
import java.util.Scanner;

public class MultiplyArray {
    // https://pintia.cn/problem-sets/994805046380707840/problems/1386335159927652359
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        int second = sc.nextInt();
        int n = sc.nextInt();
        sc.close();

        ArrayList<Integer> list = new ArrayList<>();
        list.add(first);
        list.add(second);
        for (int i = 0; i < list.size(); i++) {
            String s = String.valueOf(list.get(i) * list.get(i + 1));
            for (int k = 0; k < s.length(); k++) {
                list.add(Integer.parseInt(String.valueOf(s.charAt(k))));
            }
            if (list.size() > n) {
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                System.out.print(list.get(i));
            } else {
                System.out.print(list.get(i) + " ");
            }
        }
    }
}
