package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Lottery {
    // https://pintia.cn/problem-sets/994805046380707840/problems/1336215880692482055
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[3][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            list.add(i);
        }
        int index = 0;
        int r = 0;
        int c = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (!list.remove((Integer) (arr[i][j]))) {
                    r = i;
                    c = j;
                }
            }
        }
        arr[r][c] = list.get(0);
        for (int i = 0; i < 3; i++) {
            int row = sc.nextInt() - 1;
            int column = sc.nextInt() - 1;
            System.out.println(arr[row][column]);
        }

        int dir = sc.nextInt();
        int sum;
        switch (dir) {
            case 1:
                sum = arr[0][0] + arr[0][1] + arr[0][2];
                break;
            case 2:
                sum = arr[1][0] + arr[1][1] + arr[1][2];
                break;
            case 3:
                sum = arr[2][0] + arr[2][1] + arr[2][2];
                break;
            case 4:
                sum = arr[0][0] + arr[1][0] + arr[2][0];
                break;
            case 5:
                sum = arr[0][1] + arr[1][1] + arr[2][1];
                break;
            case 6:
                sum = arr[0][2] + arr[1][2] + arr[2][2];
                break;
            case 7:
                sum = arr[0][0] + arr[1][1] + arr[2][2];
                break;
            default:
                sum = arr[0][2] + arr[1][1] + arr[2][0];
                break;
        }
        sc.close();

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(6, 10000);
        map.put(7, 36);
        map.put(8, 720);
        map.put(9, 360);
        map.put(10, 80);
        map.put(11, 252);
        map.put(12, 108);
        map.put(13, 72);
        map.put(14, 54);
        map.put(15, 180);
        map.put(16, 72);
        map.put(17, 180);
        map.put(18, 119);
        map.put(19, 36);
        map.put(20, 306);
        map.put(21, 1080);
        map.put(22, 144);
        map.put(23, 1800);
        map.put(24, 3600);

        System.out.print(map.get(sum));
    }

}
