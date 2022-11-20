package practice.start;

import java.util.Scanner;

@SuppressWarnings("ALL")
public class CalcMedal {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] array = new int[n][3];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = input.nextInt();
            }
        }
        input.close();

        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        for (int i = 0; i < array.length; i++) {
            sum1 = sum1 + array[i][0];
            sum2 = sum2 + array[i][1];
            sum3 = sum3 + array[i][2];
        }
        int sum = sum1 + sum2 + sum3;
        System.out.printf("%d %d %d %d", sum1, sum2, sum3, sum);
    }

}
