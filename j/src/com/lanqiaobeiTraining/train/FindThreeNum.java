package com.lanqiaobeiTraining.train;

import java.util.HashSet;

public class FindThreeNum {

    public static void main(String[] args) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 102; i < 999; i++) {
            for (int j = 102; j < 999; j++) {
                for (int k = 102; k < 999; k++) {
                    if (i * 2 == j && i * 3 == k) {
                        String s = String.valueOf(i) + j + k;
                        for (int l = 0; l < s.length(); l++) {
                            set.add(s.charAt(l));
                        }
                        if (set.size() == 9) {
                            if (!set.contains('0')) {
                                System.out.println(i + " " + j + " " + k);
                            }
                        }
                        set.clear();
                    }
                }
            }
        }
    }
}
