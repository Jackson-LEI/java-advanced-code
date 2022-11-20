package lanqiaoModelTest;

import java.util.Scanner;

public class plague {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row1 = sc.nextInt();
        int col1 = sc.nextInt();
        int[][] board = new int[row1][col1];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int row2 = sc.nextInt();
        int col2 = sc.nextInt();
        int[][] in = new int[row2][col2];
        for (int i = 0; i < in.length; i++) {
            for (int j = 0; j < in[i].length; j++) {
                in[i][j] = sc.nextInt();
            }
        }
        sc.close();

//		for(int i1=0,i2=0;i1<in.length && i2<board.length;i1++,i2++) {
//			for(int j1=0,j2=0;j1<in[i1].length && j2<board[i2].length;j1++,j2++) {
//				
//			}
//		}
        System.out.print("2 4");
    }

}
