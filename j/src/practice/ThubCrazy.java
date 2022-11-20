package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ThubCrazy {
    //https://pintia.cn/problem-sets/994805046380707840/problems/994805058485469184
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        while (n > 0) {
            String[] arr = bf.readLine().split(" ");
            HashSet<String> set = new HashSet<>(Arrays.asList(arr).subList(2, arr.length));
            map.put(arr[0], new ArrayList<>());
            map.get(arr[0]).add(Integer.parseInt(arr[1]));
            map.get(arr[0]).add(set.size());
            n--;
        }
        ArrayList<Map.Entry<String, ArrayList<Integer>>> list = new ArrayList<>(map.entrySet());
        list.sort(new Comparator<>() {
            @Override
            public int compare(Map.Entry<String, ArrayList<Integer>> o1, Map.Entry<String, ArrayList<Integer>> o2) {
                if (Objects.equals(o2.getValue().get(1), o1.getValue().get(1))) {
                    return o1.getValue().get(0) - o2.getValue().get(0);
                } else {
                    return o2.getValue().get(1) - o1.getValue().get(1);
                }
            }
        });

        int count = 1;
        for (Map.Entry<String, ArrayList<Integer>> entry : list) {
            if (count == 3) {
                System.out.print(entry.getKey());
            } else {
                System.out.print(entry.getKey() + " ");
            }
            if (count == 3) {
                break;
            }
            count++;
        }
        if (map.size() < 3) {
            int out = 3 - map.size();
            for (int i = 1; i <= out; i++) {
                if (i >= out) {
                    System.out.print("-");
                } else {
                    System.out.print("-" + " ");
                }
            }
        }
    }
}
