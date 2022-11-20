package practice.start;

import java.util.Scanner;

@SuppressWarnings("ALL")
public class CalcEvenSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.close();

        int[] array = new int[n - m + 1];
        for (int index = 0; index < array.length; index++) {
            array[index] = m++;
        }

        int sum = 0;
        for (int index = 0; index < array.length; index++) {
            if (array[index] % 17 == 0) {
                sum = sum + array[index];
            }
        }
        System.out.print(sum);
    }

}
