package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SetSameRate {
    //https://pintia.cn/problem-sets/994805046380707840/problems/994805070149828608
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        int index = 1;
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        while (n > 0) {
            String[] s = bf.readLine().split(" ");
            for (int i = 1; i < s.length; i++) {
                if (!map.containsKey(index)) {
                    map.put(index, new HashSet<>());
                }
                map.get(index).add(Integer.parseInt(s[i]));
            }
            index++;
            n--;
        }

        int find = Integer.parseInt(bf.readLine());
        while (find > 0) {
            String[] s = bf.readLine().split(" ");
            Set<Integer> nc1 = new HashSet<>(map.get(Integer.parseInt(s[0])));
            Set<Integer> nc2 = new HashSet<>(map.get(Integer.parseInt(s[1])));
            nc1.retainAll(nc2);
            int nc = nc1.size();
            Set<Integer> nt1 = map.get(Integer.parseInt(s[0]));
            nc2.addAll(nt1);
            int nt = nc2.size();
            double ans = 100.0 * nc / nt;
            System.out.println(new DecimalFormat("0.00").format(ans) + "%");
            find--;
        }
        bf.close();
    }
}
