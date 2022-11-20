package com.lanqiaobeiTraining.train;

import java.util.ArrayList;
import java.util.Scanner;

public class HiAndMagic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Integer> data = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            data.add(sc.nextInt());
        }
        sc.close();

        int count = 0;
        ArrayList<Integer> remove = new ArrayList<>();
        remove.add(0);
        while (true) {
            for (int j = 0; j < data.size(); j++) {
                data.set(j, data.get(j) - 1);
                if (data.get(j) == 0) {
                    count++;
                }
            }
            if (!data.removeAll(remove)) {
                break;
            }
        }
        System.out.println(count);
    }
}
