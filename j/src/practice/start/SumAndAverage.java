package practice.start;

import java.util.Scanner;

@SuppressWarnings("ALL")
public class SumAndAverage {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] array = new int[n];

        for (int index = 0; index < array.length; index++) {
            array[index] = input.nextInt();
        }
        input.close();

        int sum = 0;
        for (int index = 0; index < array.length; index++) {
            sum = sum + array[index];
        }
        float average = (float) sum / n;
        System.out.printf("%d %.5f", sum, average);

    }

}
