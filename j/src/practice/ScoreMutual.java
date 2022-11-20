package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ScoreMutual {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int m = Integer.parseInt(s[2]);

        boolean isSame = true;
        ArrayList<String> score = new ArrayList<>();
        while (n > 0) {
            String[] line = bf.readLine().split(" ");
            for (int i = 0; i < line.length; i++) {
                if (!line[0].equals(line[i])) {
                    isSame = false;
                    break;
                }
            }
            if (line.length == 1 || isSame) {
                score.add(line[0]);
                continue;
            }
            score.add(calc(line));
            n--;
        }
        bf.close();

        Collections.sort(score);
        for (int i = score.size() - m; i < score.size(); i++) {
            if (i == score.size() - 1) {
                System.out.print(score.get(i));
            } else {
                System.out.print(score.get(i) + " ");
            }
        }
    }

    private static String calc(String[] line) {
        double sum = 0;
        Arrays.sort(line);
        for (int i = 1; i <= line.length - 2; i++) {
            sum += Integer.parseInt(line[i]);
        }
        double average = sum / (double) (line.length - 2);
        DecimalFormat df = new DecimalFormat("0.000");
        return df.format(average);
    }

}
