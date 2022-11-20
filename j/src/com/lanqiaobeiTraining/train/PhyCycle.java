package com.lanqiaobeiTraining.train;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhyCycle {
    // https://acm.njupt.edu.cn/problem/POJ1006/editor
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Integer> results = new ArrayList<>();

        while (true) {
            int p = input.nextInt();
            int e = input.nextInt();
            int i = input.nextInt();
            int d = input.nextInt();
            if (e == -1 && i == -1 && p == -1)
                break;
            int k;

            for (k = d + 1; (k - p) % 23 != 0 && k <= 21252; ++k)
                ;
            for (; (k - e) % 28 != 0 && k <= 21252; k += 23)
                ;
            for (; (k - i) % 33 != 0 && k <= 21252; k += 23 * 28)
                ;

            results.add(k - d);
        }
        input.close();

        for (int index = 0; index < results.size(); index++)
            System.out.println(
                    "Case " + (index + 1) + ": the next triple peak occurs in " + results.get(index) + " days.");

    }
}
