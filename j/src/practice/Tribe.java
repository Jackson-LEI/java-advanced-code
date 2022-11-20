package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Tribe {
    //https://pintia.cn/problem-sets/994805046380707840/problems/994805056736444416
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        ArrayList<HashSet<String>> list = new ArrayList<>();
        int sum = 0;
        while (n > 0) {
            String[] s = bf.readLine().split(" ");
            HashSet<String> temp = new HashSet<>(Arrays.asList(s).subList(1, s.length));
            if (list.isEmpty()) {
                list.add(temp);
            } else {
                boolean isContains = false;
                for (int i = 0; i < list.size(); i++) {
                    for (String x : temp) {
                        if (list.get(i).contains(x)) {
                            isContains = true;
                            list.get(i).addAll(temp);
                            break;
                        }
                    }
                }
                if (!isContains) {
                    list.add(temp);
                }
            }
            n--;
        }
        for (HashSet<String> set : list) {
            sum += set.size();
        }
        System.out.println(sum + " " + list.size());

        int find = Integer.parseInt(bf.readLine());
        while (find > 0) {
            String[] arr = bf.readLine().split(" ");
            boolean isExist = false;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).contains(arr[0])){
                    if(list.get(i).contains(arr[1])) {
                        isExist = true;
                        System.out.println("Y");
                        break;
                    }
                }
            }
            if(!isExist){
               System.out.println("N");
            }
            find--;
        }
        bf.close();
    }

}
