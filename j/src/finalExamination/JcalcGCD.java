package finalExamination;

import java.util.Scanner;

public class JcalcGCD {
    //最大公约数
    public static int gcd(int m, int n) {
        if (m % n == 0) {
            return n;
        } else {
            return gcd(n, m % n);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.print(gcd(m, n));
        sc.close();
    }

}
