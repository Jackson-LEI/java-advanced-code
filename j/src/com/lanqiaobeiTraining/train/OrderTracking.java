package com.lanqiaobeiTraining.train;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class OrderTracking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<String, Integer> map = new HashMap<>();
        Set<Entry<String, Integer>> iterate = map.entrySet();

        int pay = 0;
        int cancel = 0;
        int wait = 0;
        while (n > 0) {
            String operate = sc.next();
            if (operate.equals("CREATE")) {
                map.put(sc.next(), sc.nextInt());
            } else {
                String num = sc.next();
                if (operate.equals("PAY")) {
                    for (Entry<String, Integer> entry : iterate) {
                        String t1 = entry.getKey();
                        int t2 = entry.getValue();
                        if (t1.equals(num)) {
                            pay = pay + t2;
                            map.remove(t1, t2);
                            break;
                        }
                    }
                } else {
                    for (Entry<String, Integer> entry : iterate) {
                        String t1 = entry.getKey();
                        int t2 = entry.getValue();
                        if (t1.equals(num)) {
                            cancel = cancel + t2;
                            map.remove(t1, t2);
                            break;
                        }
                    }
                }
            }
            n--;
        }
        sc.close();
        for (Integer x : map.values()) {
            wait = wait + x;
        }
        System.out.println(pay + " " + cancel + " " + wait);
    }
}