package com.lanqiaobeiTraining.train;

import java.util.ArrayList;
import java.util.Scanner;

public class TheWarofFish {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int input = n;
        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();
        while (n > 0) {
            first.add(sc.nextInt());
            n--;
        }
        while (input > 0) {
            second.add(sc.nextInt());
            input--;
        }
        sc.close();

        int firstIndex = first.size() - 1;
        int secondIndex = 0;
        while (true) {
            if (first.get(firstIndex) > second.get(secondIndex)) {
                second.set(secondIndex, 0);
                secondIndex++;
            } else {
                first.set(firstIndex, 0);
                firstIndex--;
            }

            if (firstIndex < 0 || secondIndex >= second.size()) {
                break;
            }
        }
        ArrayList<Integer> remove = new ArrayList<>();
        remove.add(0);
        first.removeAll(remove);
        second.removeAll(remove);
        System.out.println(first.size() + second.size());

    }
}
