package com.lanqiaobeiTraining.train;

import java.util.Scanner;

public class Multiply {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();

        int ans1 = Integer.parseInt(String.valueOf(String.valueOf(b).charAt(1))) * a;
        int ans2 = Integer.parseInt(String.valueOf(String.valueOf(b).charAt(0))) * a;

//		if(String.valueOf(ans1).length())

    }

}
