package practice.start;

import java.util.Scanner;

@SuppressWarnings("ALL")
public class HighestScore {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] array = new int[n];

        for (int index = 0; index < array.length; index++) {
            array[index] = input.nextInt();
        }
        input.close();

        int max = 0;
        for (int index = 0; index < array.length; index++) {
            max = Math.max(max, array[index]);
        }
        System.out.print(max);

    }

}
