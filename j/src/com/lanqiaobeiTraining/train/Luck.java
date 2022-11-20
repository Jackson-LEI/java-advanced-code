package com.lanqiaobeiTraining.train;

import java.math.BigInteger;
import java.util.Scanner;

public class Luck {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        BigInteger n = sc.nextBigInteger();
        sc.close();

        StringBuilder four = new StringBuilder();
        StringBuilder seven = new StringBuilder();
        for (int i = 0; i < k; i++) {
            four.append("4");
            seven.append("7");
        }

        int count = 0;
        BigInteger bi = new BigInteger("1");
        while (bi.compareTo(n) <= 0) {
            String s = String.valueOf(bi);
            if (s.contains(four) || s.contains(seven)) {
                count++;
            }
            bi = bi.add(BigInteger.valueOf(1));
        }
        System.out.println(count);

    }

}
