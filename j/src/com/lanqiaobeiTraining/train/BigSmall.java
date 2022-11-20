package com.lanqiaobeiTraining.train;

import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class BigSmall {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        TreeMap<String, Integer> map = new TreeMap<>();
        sc.nextLine();
        while (n > 0) {
            String s = sc.nextLine();
            map.put(s, map.getOrDefault(s, 0) + 1);
            n--;
        }
        sc.close();

        Set<Entry<String, Integer>> set = new HashSet<>(map.entrySet());
        for (Entry<String, Integer> entry : set) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

}
