package com.lanqiaobeiTraining.train;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Book {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        ArrayList<String> list = new ArrayList<>();
        ArrayDeque<String> d = new ArrayDeque<>();
        while (n > 0) {
            d.addLast(sc.next());
            n--;
        }

        sc.nextLine();
        while (m > 0) {
            String s = sc.nextLine();
            if (s.startsWith("ADD")) {
                String book = s.substring(4, s.length() - 1);
                d.addFirst(book);
            }
            if (s.equals("ROTATE")) {
                int limit = d.size();
                while (limit > 0) {
                    list.add(d.getFirst());
                    d.removeFirst();
                    limit--;
                }
                for (int i = 0; i < list.size(); i++) {
                    d.addFirst(list.get(i));
                }
            }
            m--;
        }
        sc.close();
        for (String x : d) {
            System.out.println(x);
        }
    }
}
