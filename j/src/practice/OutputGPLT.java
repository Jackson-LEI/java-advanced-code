package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OutputGPLT {
    // https://pintia.cn/problem-sets/994805046380707840/problems/994805113036587008
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        bf.close();

        int countG = 0;
        int countP = 0;
        int countL = 0;
        int countT = 0;
        String up = s.toUpperCase();
        for (int i = 0; i < up.length(); i++) {
            if (up.charAt(i) == 'G') {
                countG++;
            }
            if (up.charAt(i) == 'P') {
                countP++;
            }
            if (up.charAt(i) == 'L') {
                countL++;
            }
            if (up.charAt(i) == 'T') {
                countT++;
            }
        }
        while (true) {
            if (countG != 0) {
                System.out.print("G");
                countG--;
            }
            if (countP != 0) {
                System.out.print("P");
                countP--;
            }
            if (countL != 0) {
                System.out.print("L");
                countL--;
            }
            if (countT != 0) {
                System.out.print("T");
                countT--;
            }

            if (countG == 0 && countP == 0 && countL == 0 && countT == 0) {
                break;
            }
        }
    }
}
