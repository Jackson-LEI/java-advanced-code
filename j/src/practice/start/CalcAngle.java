package practice.start;

import java.util.Scanner;

@SuppressWarnings("ALL")
public class CalcAngle {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int[] degree = new int[n - 1];
        for (int index = 0; index < degree.length; index++) {
            degree[index] = input.nextInt();
        }
        input.close();

        int sum = 0;
        for (int index = 0; index < degree.length; index++) {
            sum = sum + degree[index];
        }
        int angle = ((n - 2) * 180) - sum;

        System.out.print(angle);
    }

}
