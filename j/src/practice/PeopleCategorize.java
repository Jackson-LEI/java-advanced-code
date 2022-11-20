package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;

public class PeopleCategorize {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(String.valueOf(bf.readLine()));

        HashMap<Integer, Integer> map = new HashMap<>();
        TreeMap<String, List<Integer>> ans = new TreeMap<>();
        while (n > 0) {
            String[] data = bf.readLine().split(" ");
            String name = data[0];
            for (int i = 2; i < data.length; i++) {
                map.put(Integer.parseInt(data[i]), map.getOrDefault(Integer.parseInt(data[i]), 0) + 1);
            }
            ans.put(name, new ArrayList<>());
            ans.get(name).add(map.size());
            ans.get(name).add(Integer.parseInt(data[1]));
            map.clear();
            n--;
        }
        ArrayList<Entry<String, List<Integer>>> sort = new ArrayList<>(ans.entrySet());
        ArrayList<String> sorat = new ArrayList<>();
        sort.sort(new Comparator<>() {
            public int compare(Entry<String, List<Integer>> o1, Entry<String, List<Integer>> o2) {
                return o2.getValue().get(0) - o1.getValue().get(0);
            }
        });
        System.out.println(sort);
        int index = 0;
        int count = 0;
        while (true) {
            if (sort.get(index).getValue().get(0).equals(sort.get(count).getValue().get(0))) {
                count++;
            } else {
                System.out.println(sort.subList(index, count));
                index = count;
            }
            if (index > sort.size() - 1) {
                break;
            }

        }
        bf.close();
    }
}
