package com.lanqiaobeiTraining.train;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class OperateGrid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        int count = 0;
        List<Integer> sub;
        List<Integer> sum;
        while (m > 0) {
            String operate = sc.next();
            if (operate.equals("1")) {
                int index = sc.nextInt() - 1;
                int value = sc.nextInt();
                list.set(index, value);
            } else if (operate.equals("2")) {
                int x = sc.nextInt() - 1;
                int y = sc.nextInt();
                sum = list.subList(x, y);
                for (int i = 0; i < sum.size(); i++) {
                    count = count + sum.get(i);
                }
                System.out.println(count);
            } else if (operate.equals("3")) {
                int x = sc.nextInt() - 1;
                int y = sc.nextInt();
                sub = list.subList(x, y);
                System.out.println(Collections.max(sub));
            }
            count = 0;
            m--;
        }
        sc.close();
    }
}
