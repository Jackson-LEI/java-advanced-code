package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MustWin {
    //https://pintia.cn/problem-sets/994805046380707840/problems/994805086365007872
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int interval = Integer.parseInt(bf.readLine()) + 1;

        int count = 1;
        while (true) {
            String s = bf.readLine();
            if (s.equals("End")) {
                break;
            }
            if (count % interval != 0) {
                if (s.equals("JianDao")) {
                    System.out.println("ChuiZi");
                } else if (s.equals("ChuiZi")) {
                    System.out.println("Bu");
                } else if (s.equals("Bu")) {
                    System.out.println("JianDao");
                }
            } else {
                System.out.println(s);
            }
            count++;
        }
        bf.close();
    }
}
