package practice;

import java.util.Scanner;

public class MoodBigBen {
    // https://pintia.cn/problem-sets/994805046380707840/problems/1386335159927652356
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] day = new int[24];
        for (int i = 0; i < day.length; i++) {
            day[i] = sc.nextInt();
        }

        while (true) {
            int hour = sc.nextInt();
            if (hour > 23 || hour < 0) {
                break;
            }
            if (day[hour] > 50) {
                System.out.println(day[hour] + " Yes");
            } else {
                System.out.println(day[hour] + " No");
            }
        }
        sc.close();
    }

}
