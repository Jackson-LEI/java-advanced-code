package practice.start;

import java.text.DecimalFormat;
import java.util.Scanner;

@SuppressWarnings("ALL")
public class ScoreAnalysis {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n = sc.nextDouble();
        Double[] score = new Double[(int) n];

        for (int index = 0; index < score.length; index++) {
            score[index] = sc.nextDouble();
        }
        sc.close();

        int count1 = 0;
        int count2 = 0;
        for (int index = 0; index < score.length; index++) {
            if (score[index] > 65) {
                count1++;
            }
            if (score[index] > 85) {
                count2++;
            }
        }
        double rate1 = (count1 / n) * 100;
        double rate2 = (count2 / n) * 100;

        DecimalFormat df = new DecimalFormat("00");
        System.out.println(df.format(rate1) + "%");
        System.out.println(df.format(rate2) + "%");
    }

}
