package com.lanqiaobeiTraining.week2;

public class Daffodil {

    public static void main(String[] args) {
        // Ë®ÏÉ»¨Êý
        int j, k, l;
        for (int i = 100; i < 1000; i++) {
            j = i / 100;
            k = i / 10 % 10;
            l = i % 10;
            if (i == j * j * j + k * k * k + l * l * l) {
                System.out.print(i + "\t");
            }
        }
    }

}
