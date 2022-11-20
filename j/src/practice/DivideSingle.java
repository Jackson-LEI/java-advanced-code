package practice;

import java.math.BigInteger;
import java.util.Scanner;

public class DivideSingle {
    //https://pintia.cn/problem-sets/994805046380707840/problems/994805084284633088
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        StringBuilder single = new StringBuilder("1");
        String result;
        while (true) {
            BigInteger bi = new BigInteger(String.valueOf(single));
            if (bi.mod(BigInteger.valueOf(n)).equals(BigInteger.valueOf(0))) {
                result = String.valueOf(bi);
                break;
            }
            single.append("1");
        }
        BigInteger answer = new BigInteger(result);
        System.out.println(answer.divide(BigInteger.valueOf(n)) + " " + result.length());
    }
}
