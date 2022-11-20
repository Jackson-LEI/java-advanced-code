package com.lanqiaobeiTraining.train;

import java.util.HashMap;
import java.util.Scanner;

public class StringSubstract {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder s = new StringBuilder(sc.nextLine());
        sc.close();

        HashMap<Character, Integer> map = new HashMap<>();
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                result.append(" ");
                continue;
            }
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            if (map.get(s.charAt(i)) == 1) {
                result.append(s.charAt(i));
            }
            if (map.get(s.charAt(i)) == 3) {
                result.append(s.charAt(i));
            }
            if (map.get(s.charAt(i)) == 6) {
                result.append(s.charAt(i));
            }
        }
        System.out.print(result);
    }
}
