package com.lanqiaobeiTraining.train;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BiggestProduct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();

        int bring;
        int temp;
        while (n > 0) {
            int num = sc.nextInt();
            bring = sc.nextInt();

            for (int i = 0; i < num; i++) {
                list.add(sc.nextInt());
            }
            temp = 1;
            Collections.sort(list);
            for (int i = 0, j = list.size() - 1; bring > 0; ) {
                if (bring >= 2) {
                    int a1 = list.get(i) * list.get(i + 1);
                    int a2 = list.get(j) * list.get(j - 1);
                    if (a2 > a1) {
                        temp *= list.get(j);
                        j--;
                        bring--;
                    } else {
                        temp *= a1;
                        i = i + 2;
                        bring = bring - 2;
                    }
                } else {
                    if (bring == 1) {
                        temp *= list.get(j);
                        j--;
                        bring--;
                    }
                }
            }
            n--;
            System.out.println(temp);
            list.clear();
        }
        sc.close();
    }
}
