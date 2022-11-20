package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class CelebritesAndDiscount {
    //https://pintia.cn/problem-sets/994805046380707840/problems/994805056736444416
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = bf.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int border = Integer.parseInt(arr[1]);
        int rank = Integer.parseInt(arr[2]);

        int sum = 0;
        TreeMap<String, Integer> map = new TreeMap<>();
        while (n > 0) {
            String[] data = bf.readLine().split(" ");
            int score = Integer.parseInt(data[1]);
            if (score >= border) {
                sum += 50;
            }
            if (score >= 60 && score < border) {
                sum += 20;
            }
            map.put(data[0], Integer.parseInt(data[1]));
            n--;
        }
        bf.close();

        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(new Comparator<>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o2.getValue().equals(o1.getValue())) {
                    return o1.getKey().compareTo(o2.getKey());
                } else {
                    return o2.getValue() - o1.getValue();
                }
            }
        });

        int count = 1;
        System.out.println(sum);
        for (int i = 0; rank >= count && i < list.size(); i++) {
            System.out.println(count + " " + list.get(i).getKey() + " " + list.get(i).getValue());
            if (i != list.size() - 1 && !(list.get(i).getValue().equals(list.get(i + 1).getValue()))) {
                count = i + 2;
            }
        }
    }
}
