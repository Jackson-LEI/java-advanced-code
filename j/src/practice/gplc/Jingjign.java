package practice.gplc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Jingjign {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = bf.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int k = Integer.parseInt(arr[1]);
        int s = Integer.parseInt(arr[2]);

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        while(n>0){
            String[] data = bf.readLine().split(" ");
            ArrayList<Integer> temp = new ArrayList<>();
            for(String x:data){
                temp.add(Integer.valueOf(x));
            }
            list.add(new ArrayList<>(temp));
            temp.clear();
            n--;
        }
        list.sort(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if(o1.get(0)==o2.get(0)){
                    return o2.get(1) - o1.get(1);
                }else{
                    return o1.get(0) - o2.get(0);
                }
            }
        });
        list.forEach(System.out::println);
    }
}
