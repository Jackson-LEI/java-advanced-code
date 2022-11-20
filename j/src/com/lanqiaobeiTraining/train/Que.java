package com.lanqiaobeiTraining.train;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Que {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        while (n > 0) {
            int operate = sc.nextInt();
            if (operate == 1) {
                int put = sc.nextInt();
                queue.add(put);
            } else if (operate == 2) {
                if (queue.size() == 0) {
                    System.out.println("no");
                    continue;
                }
                System.out.println(queue.removeFirst());
            } else {
                System.out.println(queue.size());
            }
            n--;
        }
        sc.close();
    }
}
