package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BigBen {
    // https://pintia.cn/problem-sets/994805046380707840/problems/994805119944605696
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        bf.close();

        int hour = Integer.parseInt(s.substring(0, s.indexOf(':')));
        int minute = Integer.parseInt(s.substring(s.indexOf(':') + 1, 5));

        if (hour <= 12) {
            System.out.print("Only " + s.substring(0, s.indexOf(':')) + ":" + s.substring(s.indexOf(':') + 1, 5)
                    + ".  Too early to Dang.");
            return;
        }

        int timeTrans = hour - 12;
        for (int i = 1; i <= timeTrans; i++) {
            System.out.print("Dang");
        }

        if (minute > 0) {
            System.out.print("Dang");
        }
    }

}
