package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class KindnessOfContest {
    // https://pintia.cn/problem-sets/994805046380707840/problems/1386335159927652358
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        String[] s = bf.readLine().split(" ");
        for (int i = 0; i < s.length; i++) {
            list.add(Integer.parseInt(s[i]));
        }
        bf.close();

        int countMin = 0;
        int countMax = 0;
        int min = Collections.min(list);
        int max = Collections.max(list);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == min) {
                countMin++;
            }
            if (list.get(i) == max) {
                countMax++;
            }
        }

        System.out.println(min + " " + countMin);
        System.out.println(max + " " + countMax);
    }
}
