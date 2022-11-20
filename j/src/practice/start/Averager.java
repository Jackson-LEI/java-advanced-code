package practice.start;

import java.util.Scanner;

@SuppressWarnings("ALL")
public class Averager {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        float[] array = new float[n];

        for (int index = 0; index < array.length; index++) {
            array[index] = input.nextFloat();
        }
        input.close();

        float sum = 0;
        for (int index = 0; index < array.length; index++) {
            sum = sum + array[index];
        }
        float average = sum / n;
        System.out.printf("%.4f", average);
    }

}
