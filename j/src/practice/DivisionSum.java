package practice;

import java.util.Scanner;

public class DivisionSum {
    // https://pintia.cn/problem-sets/994805046380707840/problems/994805133597065216
    public static long gcd(long m, long n) {
        if (m % n == 0) {
            return n;
        } else {
            return gcd(n, m % n);
        }
    }

    public static long lcm(long[] arr) {
        long lcm = (arr[0] * arr[1]) / gcd(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            lcm = (lcm * arr[i]) / gcd(lcm, arr[i]);
        }
        return lcm;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int times = sc.nextInt();
        String[] s = new String[times];

        for (int i = 0; i < s.length; i++) {
            s[i] = sc.next();
        }
        sc.close();

        long[] arr = new long[s.length];
        for (int i = 0; i < arr.length; i++) {
            long q = Long.parseLong(s[i].substring(s[i].indexOf('/') + 1));
            arr[i] = q;
        }

        long dividUp = 0;
        long publicDivisor = lcm(arr);
        for (int i = 0; i < s.length; i++) {
            if (s[i].charAt(0) != '-') {
                long q = Long.parseLong(s[i].substring(0, s[i].indexOf('/')));
                dividUp += q * (publicDivisor / arr[i]);
            } else {
                long q = Long.parseLong(s[i].substring(1, s[i].indexOf('/')));
                dividUp -= q * (publicDivisor / arr[i]);
            }
        }

        long integerNumber = dividUp / publicDivisor;
        if (dividUp / publicDivisor != 0) {
            if (dividUp % publicDivisor > 0) {
                System.out.print(integerNumber + " ");
            } else {
                System.out.print(integerNumber);
            }
        }

        long reductionUp = dividUp / gcd(dividUp, publicDivisor);
        long reductionDown = publicDivisor / gcd(dividUp, publicDivisor);
        long substractionResult = reductionUp - reductionDown * (reductionUp / reductionDown);

        if (reductionUp == 0) {
            System.out.print("0");
            return;
        }

        if (dividUp % publicDivisor > 0) {
            System.out.print(substractionResult + "/" + reductionDown);
        } else if (dividUp % publicDivisor < 0) {
            reductionDown = Math.abs(reductionDown);
            substractionResult = Math.abs(substractionResult);
            System.out.print("-" + substractionResult + "/" + reductionDown);
        }
    }
}
