package com.lanqiaobeiTraining.train;

import java.util.ArrayList;
import java.util.Scanner;

public class Compare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        while (m > 0) {
            int from1 = sc.nextInt() - 1;
            int to1 = sc.nextInt() - 1;
            int from2 = sc.nextInt() - 1;
            int to2 = sc.nextInt() - 1;
            ArrayList<Integer> list1 = new ArrayList<>();
            ArrayList<Integer> list2 = new ArrayList<>();
            ArrayList<Integer> ans = new ArrayList<>();
            for (int i = from1; i <= to1; i++) {
                list1.add(arr[i]);
            }
            for (int i = from2; i <= to2; i++) {
                list2.add(arr[i]);
            }

            for (int i = 0; i < list2.size(); i++) {
                int count = 0;
                for (int j = 0; j < list1.size(); j++) {
                    if (list2.get(i) >= list1.get(j)) {
                        count++;
                    }
                }
                ans.add(count);
            }
            ans.forEach(a -> System.out.print(a + " "));
            System.out.println();
            m--;
        }
        sc.close();
    }
}
