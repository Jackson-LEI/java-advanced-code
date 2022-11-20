package practice;

import java.util.*;
import java.util.Map.Entry;

public class RankingSystem {
    // https://ac.nowcoder.com/acm/problem/19971
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        HashMap<String, Integer> map = new HashMap<>();
        while (n > 0) {
            String s = sc.next();
            if (s.charAt(0) == '+') {
                int score = sc.nextInt();
                map.put(s.substring(1), score);
            } else if (s.charAt(0) == '?') {
                List<Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
                list.sort(new Comparator<>() {
                    public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                        return o2.getValue() - o1.getValue();
                    }
                });
                for (Entry<String, Integer> entry : list) {
                    System.out.println(entry.getKey() + " " + entry.getValue());
                }

                List<String> name = new ArrayList<>();
//				for (Entry<String, Integer> entry : list) {
//					name.add(entry.getKey());
//				}
                if (Character.isAlphabetic(s.charAt(1))) {
                    for (Entry<String, Integer> entry : list) {
                        String temp = entry.getKey();
                        if (s.substring(1).equals(temp)) {
                            System.out.print(name.indexOf(temp) + 1);
                        }
                    }
                } else {
                    int index = Integer.parseInt(s.substring(1)) - 1;
                    for (int i = index; i < index + 10; i++) {
                        if (i < name.size()) {
                            System.out.print(name.get(i) + " ");
                        }
                    }
                    System.out.println();
                }
            }
            n--;
        }
        sc.close();
    }
}