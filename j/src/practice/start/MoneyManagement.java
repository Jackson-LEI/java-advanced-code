package practice.start;

import java.util.Scanner;

public class MoneyManagement {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        float[] array = new float[12];
        for (int index = 0; index < array.length; index++) {
            array[index] = input.nextFloat();
        }
        input.close();

        float sum = 0;
        for (int index = 0; index < array.length; index++) {
            sum = sum + array[index];
        }
        float average = sum / array.length;
        System.out.printf("$%.2f", average);

    }

}
