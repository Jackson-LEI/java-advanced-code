package com.lanqiaobeiTraining.train;

import java.util.ArrayList;
import java.util.Scanner;

public class TopicAnalyze {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] length = new int[n];
        for (int i = 0; i < length.length; i++) {
            sc.nextInt();
        }
        sc.nextLine();

        ArrayList<String> list = new ArrayList<>();
        while (n > 0) {
            list.add(sc.nextLine());
            n--;
        }

        String line = sc.nextLine();
        String[] artical = line.split(" ");
        sc.close();

        int count = 0;
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            String[] compare = s.split(" ");
            for (int j = 0; j < compare.length; j++) {
                for (int k = 0; k < artical.length; k++) {
                    if (compare[j].equals(artical[k])) {
                        count++;
                    }
                }
            }
            result.add(count);
            count = 0;
        }
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
