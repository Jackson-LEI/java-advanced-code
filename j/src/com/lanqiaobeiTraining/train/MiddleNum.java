package com.lanqiaobeiTraining.train;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class MiddleNum {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        String[] arr = bf.readLine().split(" ");
        for (int i = 0; i < arr.length; i++) {
            list.add(Integer.parseInt(arr[i]));
            Collections.sort(list);
            if (list.size() == 1) {
                System.out.print(list.get(0) + " ");
                n--;
                continue;
            }
            if (list.size() % 2 != 0) {
                System.out.print(list.get(((list.size() + 1) / 2) - 1) + " ");
            }
        }
        bf.close();

    }
}
