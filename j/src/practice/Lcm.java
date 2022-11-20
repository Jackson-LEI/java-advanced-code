package practice;

import java.util.Scanner;

public class Lcm {
    public static int gcd(int m, int n) {
        if (m % n == 0) {
            return n;
        } else {
            return gcd(n, m % n);
        }
    }

    public static int lcm(int[] arr) {
        int lcm = (arr[0] * arr[1]) / gcd(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            lcm = (lcm * arr[i]) / gcd(lcm, arr[i]);
        }
        return lcm;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        int[] arr = new int[a];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        System.out.print(lcm(arr));
    }

}