package com.lanqiaobeiTraining.train;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubStringSum {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        bf.close();

        int sum = 0;
        int len = s.length();
        for (int i = 0; i < s.length(); i++) {
            int j = s.lastIndexOf(s.charAt(i));
            String sub = s.substring(0, j - 1);
            int a = sub.lastIndexOf(s.charAt(i));
            sum += (i - a) * s.length() * (len - i);
        }
        System.out.print(sum);
    }

}
