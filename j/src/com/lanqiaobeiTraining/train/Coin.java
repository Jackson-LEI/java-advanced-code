package com.lanqiaobeiTraining.train;

import java.util.ArrayList;
import java.util.Scanner;

public class Coin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int day = sc.nextInt();
        sc.close();

        int time = 1;
        int num = 1;
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>(day);
        while (count < day) {
            while (time > 0) {
                list.add(num);
                count++;
                time--;
            }
            num++;
            time = num;
        }
        int sum = 0;
        for (int x : list) {
            sum += x;
        }
        System.out.println(sum);
    }
}
