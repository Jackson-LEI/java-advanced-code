package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Like {
    // https://pintia.cn/problem-sets/994805046380707840/problems/994805098188750848
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        bf.readLine();
        HashMap<String, Integer> map = new HashMap<>();
        while (n > 0) {
            String s = bf.readLine();
            String[] arr = s.split(" ");
            for (int i = 1; i < arr.length; i++) {
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }
            n--;
        }
        bf.close();

        String maxKey = "0";
        int maxValue = 0;
        for (String s : map.keySet()) {
            if (map.get(s) > maxValue) {
                maxValue = map.get(s);
                maxKey = s;
            }

            if (map.get(s) == maxValue) {
                if (Integer.parseInt(s) > Integer.parseInt(maxKey)) {
                    maxKey = s;
                }
            }
        }

        System.out.print(maxKey + " " + maxValue);

    }
}
