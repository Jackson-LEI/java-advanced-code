package practice.start;

import java.util.Scanner;

@SuppressWarnings("ALL")
public class HighestMinusValue {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] array = new int[n];

        for (int index = 0; index < array.length; index++) {
            array[index] = input.nextInt();
        }
        input.close();

        int max = 0;
        int min = 0;
        for (int index = 0; index < array.length; index++) {
            max = Math.max(max, array[index]);
            min = Math.min(min, array[index]);
        }
        int minusValue = max - min;
        System.out.print(minusValue);
    }

}
