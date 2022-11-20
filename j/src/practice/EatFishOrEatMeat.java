package practice;

import java.util.Scanner;

public class EatFishOrEatMeat {
    // https://pintia.cn/problem-sets/994805046380707840/problems/1111914599412858884
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while (n > 0) {
            int gender = sc.nextInt();
            int height = sc.nextInt();
            int weight = sc.nextInt();

            if (gender == 1) {
                if (height > 130) {
                    System.out.print("ni li hai! ");
                } else if (height == 130) {
                    System.out.print("wan mei! ");
                } else {
                    System.out.print("duo chi yu! ");
                }

                if (weight > 27) {
                    System.out.print("shao chi rou!");
                } else if (weight == 27) {
                    System.out.print("wan mei!");
                } else {
                    System.out.print("duo chi rou!");
                }
            } else {
                if (height > 129) {
                    System.out.print("ni li hai! ");
                } else if (height == 129) {
                    System.out.print("wan mei! ");
                } else {
                    System.out.print("duo chi yu! ");
                }

                if (weight > 25) {
                    System.out.print("shao chi rou!");
                } else if (weight == 25) {
                    System.out.print("wan mei!");
                } else {
                    System.out.print("duo chi rou!");
                }
            }
            System.out.println();
            n--;
        }
        sc.close();
    }
}
