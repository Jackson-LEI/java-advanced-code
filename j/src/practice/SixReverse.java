package practice;

import java.util.Scanner;

public class SixReverse {
    //https://pintia.cn/problem-sets/994805046380707840/problems/1111914599408664577
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print(sc.nextLine().replaceAll("6{10,}", "27").replaceAll("6{4,9}", "9"));
        sc.close();
    }
}
