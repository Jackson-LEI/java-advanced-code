package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

public class QuietlyAttention {
    //https://pintia.cn/problem-sets/994805046380707840/problems/994805059731177472
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] atten = bf.readLine().split(" ");
        HashSet<String> attPeople = new HashSet<>(Arrays.asList(atten).subList(1, atten.length - 1));
        int n = Integer.parseInt(bf.readLine());
        int temp = n;
        TreeMap<String, Integer> map = new TreeMap<>();
        int sum = 0;
        while (n > 0) {
            String[] thub = bf.readLine().split(" ");
            map.put(thub[0], Integer.parseInt(thub[1]));
            sum += Integer.parseInt(thub[1]);
            n--;
        }
        bf.close();
        int avr = sum / temp;

        boolean notContains = false;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String name = entry.getKey();
            int thubNum = entry.getValue();
            if (thubNum > avr) {
                if (!attPeople.contains(name)) {
                    System.out.println(name);
                    notContains = true;
                }
            }
        }
        if (!notContains) {
            System.out.println("Bing Mei You");
        }
    }
}
