package practice;

import java.util.Scanner;

public class JudgePrime {
    public static void main(String[] args) {
        // (只用于测试的类)
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        boolean isPrime = true;
        while (n > 0) {
            long num = sc.nextLong();
            if (num == 2) {
                System.out.println("Yes");
                break;
            }
            if (num <= 1) {
                System.out.println("No");
                break;
            }
            for (long i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (!isPrime) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
            n--;
            isPrime = true;
        }
        sc.close();
    }
}
