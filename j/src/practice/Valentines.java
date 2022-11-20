package practice;

import java.util.ArrayList;
import java.util.Scanner;

public class Valentines {
    //https://pintia.cn/problem-sets/994805046380707840/problems/994805097018540032
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();

        while (true) {
            String s = sc.nextLine();
            if (s.equals(".")) {
                break;
            }
            list.add(s);
        }
        sc.close();

        if (list.size() > 1) {
            if (list.size() >= 14) {
                System.out.println(list.get(1) + " and " + list.get(13) + " are inviting you to dinner...");
            } else {
                System.out.println(list.get(1) + " is the only one for you...");
            }
        } else {
            System.out.println("Momo... No one is for you ...");
        }
    }
}
