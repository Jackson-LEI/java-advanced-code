package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class PackageMachine {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = bf.readLine().split(" ");

        int row = Integer.parseInt(arr[0]);
        int size = Integer.parseInt(arr[3]);
        ArrayList<ArrayDeque<Character>> list = new ArrayList<>();
        while(row>0){
            char[] ch  = bf.readLine().toCharArray();
            ArrayDeque<Character> deque = new ArrayDeque<>();
        }
    }

}