package com.lanqiaobeiTraining.train;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MatrixMultiply {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = bf.readLine().split(" ");
        int row1 = Integer.parseInt(line1[0]);
        int column1_row2 = Integer.parseInt(line1[1]);
        int column2 = Integer.parseInt(line1[2]);

        int[][] m1 = new int[row1][column1_row2];
        for (int i = 0; i < m1.length; i++) {
            String[] data = bf.readLine().split(" ");
            for (int j = 0; j < m1[i].length; j++) {
                m1[i][j] = Integer.parseInt(data[j]);
            }
        }

        int[][] m2 = new int[column1_row2][column2];
        for (int i = 0; i < m2.length; i++) {
            String[] data = bf.readLine().split(" ");
            for (int j = 0; j < m2[i].length; j++) {
                m2[i][j] = Integer.parseInt(data[j]);
            }
        }
        bf.close();

        int[][] result = new int[row1][column2];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < column2; j++) {
                for (int k = 0; k < column1_row2; k++) {
                    result[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < column2; j++) {
                if (j == column2 - 1) {
                    System.out.println(result[i][j]);
                } else {
                    System.out.print(result[i][j] + " ");
                }
            }
        }
    }
}
