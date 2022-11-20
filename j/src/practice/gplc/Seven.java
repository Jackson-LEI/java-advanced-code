package practice.gplc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Seven {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = bf.readLine().split(" ");
        int row = Integer.parseInt(arr[0]);
        int column = Integer.parseInt(arr[1]);
        int attack = Integer.parseInt(arr[2]);

        int[][] p = new int[row][column];

        while(attack>0){
            String[] att = bf.readLine().split(" ");
            int rc = Integer.parseInt(att[0]);
            int num = Integer.parseInt(att[1]) - 1;
            if(rc==0){
                for(int i=0;i<column;i++){
                    p[i][num] = 1;
                }
            }else{
                for(int i=0;i<row;i++){
                    p[num][i] = 1;
                }
            }
            attack--;
        }
        bf.close();

        int count = 0;
        for(int i=0;i<p.length;i++){
            for(int j=0;j<p[i].length;j++){
                if(p[i][j]==0){
                    count++;
                }
                System.out.print(p[i][j]);
            }
            System.out.println();
        }
        System.out.println(count);
    }
}
