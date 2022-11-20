package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class RedPacket {
    // https://pintia.cn/problem-sets/994805046380707840/problems/994805066890854400
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[][] data = new int[n][3];

        int index = 0;
        HashSet<Integer> num = new HashSet<>();
        while (n > 0) {
            String[] s = bf.readLine().split(" ");
            data[index][2] = Integer.parseInt(s[0]);
            data[index][0] = index + 1;
            for (int i = 1, i1 = 2; i < s.length; i += 2, i1 += 2) {
                if (!num.add(Integer.parseInt(s[i]) - 1)) {
                    continue;
                }
                data[index][1] -= Integer.parseInt(s[i1]);
                data[Integer.parseInt(s[i]) - 1][1] += Integer.parseInt(s[i1]);
            }
            num.clear();
            index++;
            n--;
        }
        bf.close();

        Arrays.sort(data, new Comparator<>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] != b[1]) {
                    return b[1] - a[1];
                } else if (a[2] != b[2]) {
                    return b[2] - a[2];
                } else {
                    return a[0] - b[0];
                }
            }
        });

        for (int i = 0; i < data.length; i++) {
            double temp = data[i][1] / 100.0;
            String s = String.format("%.2f", temp);
            System.out.println(data[i][0] + " " + s);
        }
    }
}
