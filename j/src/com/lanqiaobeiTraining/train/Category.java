package com.lanqiaobeiTraining.train;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Category {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Double> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(sc.nextDouble());
        }
        sc.close();

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        for (int i = 0; i < list.size() - 1; i++) {
            double temp = list.get(i + 1) - list.get(i);
            System.out.print(new DecimalFormat("0.00").format(temp) + " ");
        }
    }

}
