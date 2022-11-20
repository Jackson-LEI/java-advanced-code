package practice;

import java.util.ArrayList;
import java.util.Scanner;

public class OneHelpAnother {
    // https://pintia.cn/problem-sets/994805046380707840/problems/994805103557459968
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(sc.nextLine());
        }
        sc.close();

        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).startsWith("0")) {
                for (int j = list.size() - 1; j >= 0; j--) {
                    if (list.get(j).startsWith("1")) {
                        result.add(list.get(i).substring(2) + " " + list.get(j).substring(2));
                        list.set(i, "empty");
                        list.set(j, "empty");
                        break;
                    }
                }
            } else if (list.get(i).startsWith("1")) {
                for (int j = list.size() - 1; j >= 0; j--) {
                    if (list.get(j).startsWith("0")) {
                        result.add(list.get(i).substring(2) + " " + list.get(j).substring(2));
                        list.set(i, "empty");
                        list.set(j, "empty");
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}