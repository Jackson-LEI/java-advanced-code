package practice;

import java.util.HashSet;
import java.util.Scanner;

public class TyrePressure {
    // https://pintia.cn/problem-sets/994805046380707840/problems/1336215880692482052
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] tyre = new int[4];
        for (int i = 0; i < tyre.length; i++) {
            tyre[i] = sc.nextInt();
        }
        int limit = sc.nextInt();
        int minus = sc.nextInt();
        sc.close();

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < tyre.length; i++) {
            if (tyre[i] < limit) {
                set.add(i + 1);
            }
            for (int j = i + 1; j < tyre.length; j++) {
                if (Math.abs(tyre[i] - tyre[j]) > minus) {
                    if (tyre[i] < tyre[j]) {
                        set.add(i + 1);
                    } else {
                        set.add(j + 1);
                    }
                }
            }
        }

        if (set.isEmpty()) {
            System.out.println("Normal");
        } else if (set.size() >= 2) {
            System.out.println("Warning: please check all the tires!");
        } else {
            for (int x : set) {
                System.out.println("Warning: please check #" + x + "!");
            }
        }
    }
}
