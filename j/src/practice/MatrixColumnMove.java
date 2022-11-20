package practice;

import java.util.Scanner;

public class MatrixColumnMove {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int move = sc.nextInt();
        int comp = sc.nextInt();

        int[][] arr = new int[n][n];
        for(int i=0;i<arr.length;i++){
            for(int j=0;i<arr[i].length;i++){
                arr[i][j] = sc.nextInt();
            }
        }
        sc.close();

        for(int i=0;i<n;i++){
            if((i+1)%2==0){
//                for(int j=)
            }
        }
    }
}
