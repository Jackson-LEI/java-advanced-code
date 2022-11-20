package com.lanqiaobeiTraining.train;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class ScoreSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        TreeMap<String, Integer> map = new TreeMap<>();
        while (n > 0) {
            map.put(sc.next(), sc.nextInt());
            n--;
        }
        sc.close();

        ArrayList<Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(new Comparator<>() {
            @Override
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        for (Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey());
        }
    }
}
