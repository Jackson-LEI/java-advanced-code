package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.text.DecimalFormat;

public class Become2 {
    // https://pintia.cn/problem-sets/994805046380707840/problems/994805121500692480
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        br.close();

        int count2 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '2') {
                count2++;
            }
        }

        double result;
        int length = s.length();
        if (s.charAt(0) == '-') {
            length = length - 1;
            result = (double) count2 / length * 1.5;
        } else {
            result = (double) count2 / length;
        }

        BigInteger bi = new BigInteger(s);
        if (bi.mod(BigInteger.valueOf(2)).equals(BigInteger.valueOf(0))) {
            result = result * 2;
        }

        DecimalFormat df = new DecimalFormat("0.00");
        System.out.print(df.format(result * 100) + "%");
    }
}
