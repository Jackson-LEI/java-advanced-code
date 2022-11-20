package com.lanqiaobeiTraining.train;

import java.util.Scanner;

public class StringOperate {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String orgin = sc.nextLine();
        int n = sc.nextInt();

        StringBuilder sb = new StringBuilder(orgin);
        sc.nextLine();
        while (n > 0) {
            String operate = sc.next();
            if (operate.startsWith("Append")) {
                String append = sc.next();
                sb.append(append);
            } else if (operate.startsWith("Insert")) {
                int index = sc.nextInt();
                String insert = sc.next();
                sb.insert(3, insert);
            } else if (operate.startsWith("Reverse")) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                StringBuffer reverse = new StringBuffer(sb.substring(from + 1, to)).reverse();
                sb.delete(from + 1, to);
                sb.insert(from + 1, reverse);
            } else {
                int swap1From = sc.nextInt();
                int swap1To = sc.nextInt();
                int swap2From = sc.nextInt();
                int swap2To = sc.nextInt();
                String swapFrom = sb.substring(swap1From + 1, swap1To);
                String swapTo = sb.substring(swap2From + 1, swap2To);
                sb.replace(swap1From + 1, swap1To, swapTo);
                sb.replace(swap2From + 1, swap2To, swapTo);
            }
            n--;
        }
        sc.close();
    }
}
