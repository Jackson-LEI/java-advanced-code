package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CodeBaseClearance {
    //https://pintia.cn/problem-sets/994805046380707840/problems/1386335159927652362
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        int n = Integer.parseInt(s[0]);

        HashSet<ArrayList<String>> set = new HashSet<>();
        TreeMap<ArrayList<String>, Integer> map = new TreeMap<>(new Comparator<>() {
            @Override
            public int compare(ArrayList<String> o1, ArrayList<String> o2) {
                if (o1.get(0).equals(o2.get(0))) {
                    if (o1.get(1).equals(o2.get(1))) {
                        return o1.get(2).compareTo(o2.get(2));
                    } else {
                        return o1.get(1).compareTo(o2.get(1));
                    }
                } else {
                    return o1.get(0).compareTo(o2.get(0));
                }
            }
        });
        while (n > 0) {
            String[] arr = bf.readLine().split(" ");
            ArrayList<String> list = new ArrayList<>(Arrays.asList(arr));
            if (!set.add(list)) {
                map.put(list, map.get(list) + 1);
            } else {
                map.put(list, 1);
            }
            n--;
        }
        bf.close();

        ArrayList<Map.Entry<ArrayList<String>, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(new Comparator<>() {
            @Override
            public int compare(Map.Entry<ArrayList<String>, Integer> o1, Map.Entry<ArrayList<String>, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        System.out.println(list.size());
        for (Map.Entry<ArrayList<String>, Integer> i : list) {
            System.out.print(i.getValue() + " ");
            ArrayList<String> temp = new ArrayList<>(i.getKey());
            for (int j = 0; j < temp.size(); j++) {
                if (j == temp.size() - 1) {
                    System.out.print(temp.get(j));
                }else{
                    System.out.print(temp.get(j) + " ");
                }
            }
            System.out.println();
        }
    }
}
