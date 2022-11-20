package com.lanqiaobeiTraining.train;

import java.util.Scanner;
//import java.util.StringTokenizer;

public class Password {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
//		StringTokenizer st = new StringTokenizer(s,"|");
//		while(st.hasMoreTokens()) {
//			System.out.println(st.nextToken());
//		}
        String[] arr = s.split("\\|");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("*-")) {
                arr[i] = "a";
            } else if (arr[i].equals("-***")) {
                arr[i] = "b";
            } else if (arr[i].equals("-*-*")) {
                arr[i] = "c";
            } else if (arr[i].equals("-***")) {
                arr[i] = "d";
            } else if (arr[i].equals("*")) {
                arr[i] = "e";
            } else if (arr[i].equals("**-*")) {
                arr[i] = "f";
            } else if (arr[i].equals("--*")) {
                arr[i] = "g";
            } else if (arr[i].equals("****")) {
                arr[i] = "h";
            } else if (arr[i].equals("**")) {
                arr[i] = "i";
            } else if (arr[i].equals("-*-*")) {
                arr[i] = "j";
            } else if (arr[i].equals("-*-")) {
                arr[i] = "k";
            } else if (arr[i].equals("*-**")) {
                arr[i] = "l";
            } else if (arr[i].equals("--")) {
                arr[i] = "m";
            } else if (arr[i].equals("-*")) {
                arr[i] = "n";
            } else if (arr[i].equals("---")) {
                arr[i] = "o";
            } else if (arr[i].equals("*--*")) {
                arr[i] = "p";
            } else if (arr[i].equals("--*-")) {
                arr[i] = "q";
            } else if (arr[i].equals("*-*")) {
                arr[i] = "r";
            } else if (arr[i].equals("***")) {
                arr[i] = "s";
            } else if (arr[i].equals("-")) {
                arr[i] = "t";
            } else if (arr[i].equals("**-")) {
                arr[i] = "u";
            } else if (arr[i].equals("***-")) {
                arr[i] = "v";
            } else if (arr[i].equals("*--")) {
                arr[i] = "w";
            } else if (arr[i].equals("*--*")) {
                arr[i] = "x";
            } else if (arr[i].equals("-*--")) {
                arr[i] = "y";
            } else if (arr[i].equals("--**")) {
                arr[i] = "z";
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}
