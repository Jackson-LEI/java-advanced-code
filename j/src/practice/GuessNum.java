package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class GuessNum {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int temp = n;

        ArrayList<String> name = new ArrayList<>();
        ArrayList<Integer> num = new ArrayList<>();

        while (n > 0) {
            String[] s = bf.readLine().split(" ");
            name.add(s[0]);
            num.add(Integer.parseInt(s[1]));
            n--;
        }

        int sum = 0;
        for (int i = 0; i < num.size(); i++) {
            sum = sum + num.get(i);
        }
        int halfAverage = sum / temp / 2;

        ArrayList<Integer> minus = new ArrayList<>();
        for (int i = 0; i < num.size(); i++) {
            minus.add(Math.abs(num.get(i) - halfAverage));
        }

        int index = 0;
        int min = Collections.min(minus);
        for (int i = 0; i < minus.size(); i++) {
            if (min == minus.get(i)) {
                index = i;
            }
        }

        System.out.println(halfAverage + " " + name.get(index));
    }
}
