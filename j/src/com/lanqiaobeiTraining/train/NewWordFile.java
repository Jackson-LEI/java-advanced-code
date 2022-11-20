package com.lanqiaobeiTraining.train;

import java.util.ArrayList;
import java.util.Scanner;

public class NewWordFile {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int index;
        int count;
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();
        sc.nextLine();
        while (n > 0) {
            String s = sc.nextLine();
            if (s.equals("New")) {
                if (list.contains(0)) {
                    index = list.indexOf(0);
                    count = index + 1;
                    list.set(index, count);
                    result.add(String.valueOf(count));
                    n--;
                    continue;
                }
                list.add(list.size() + 1);
                result.add(String.valueOf(list.size()));
            }
            if (s.startsWith("Delete")) {
                int delete = Integer.parseInt(s.substring(7));
                if (list.size() >= delete && list.get(delete - 1) != 0) {
                    list.set(delete - 1, 0);
                    result.add("Successful");
                } else {
                    result.add("Failed");
                }
            }
            n--;
        }
        sc.close();
        for (String x : result) {
            System.out.println(x);
        }
    }
}
