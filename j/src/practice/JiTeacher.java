package practice;

import java.util.ArrayList;
import java.util.Scanner;

public class JiTeacher {
    // https://pintia.cn/problem-sets/994805046380707840/problems/1386335159927652357
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int done = sc.nextInt();

        if (n == done) {
            System.out.print("Wo AK le");
            sc.close();
            return;
        }
        sc.nextLine();

        ArrayList<String> list = new ArrayList<>();
        while (n > 0) {
            String s = sc.nextLine();
            if (!(s.contains("qiandao") || s.contains("easy"))) {
                list.add(s);
            }
            n--;
        }
        sc.close();

        int leave = done - list.size();
        if (leave >= 0) {
            System.out.print("Wo AK le");
        } else {
            for (int i = 0; i < Math.abs(done); i++) {
                list.remove(0);
            }
            System.out.print(list.get(0));
        }

    }
}
