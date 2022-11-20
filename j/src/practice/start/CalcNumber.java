package practice.start;

import java.util.Scanner;

@SuppressWarnings("ALL")
public class CalcNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int[] array = new int[k];
        for (int index = 0; index < array.length; index++) {
            array[index] = sc.nextInt();
        }
        sc.close();

        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        for (int index = 0; index < array.length; index++) {
            if (array[index] == 1) {
                sum1++;
            }
            if (array[index] == 5) {
                sum2++;
            }
            if (array[index] == 10) {
                sum3++;
            }
        }
        System.out.println(sum1);
        System.out.println(sum2);
        System.out.println(sum3);
    }

}
