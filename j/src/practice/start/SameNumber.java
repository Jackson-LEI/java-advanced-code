package practice.start;

import java.util.Scanner;

@SuppressWarnings("ALL")
public class SameNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] array = new int[n];
        for (int index = 0; index < array.length; index++) {
            array[index] = sc.nextInt();
        }
        sc.close();

        int sum = 0;
        for (int index = 0; index < array.length; index++) {
            if (array[index] == m) {
                sum++;
            }
        }
        System.out.print(sum);

    }

}
