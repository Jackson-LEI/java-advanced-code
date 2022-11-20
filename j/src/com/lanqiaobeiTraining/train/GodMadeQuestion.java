package com.lanqiaobeiTraining.train;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class GodMadeQuestion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int range = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        ArrayList<Integer> rangeList = new ArrayList<>();
        ArrayList<Integer> answer = new ArrayList<>();
        while (range > 0) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            while (from <= to) {
                rangeList.add(list.get(from++));
            }
            answer.add(Collections.min(rangeList));
            rangeList.clear();
            range--;
        }
        sc.close();

        Iterator<Integer> i = answer.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}
