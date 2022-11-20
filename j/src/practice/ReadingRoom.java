package practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ReadingRoom {
    // https://pintia.cn/problem-sets/994805046380707840/problems/994805087447138304
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        int day = sc.nextInt();
        ArrayList<String> num = new ArrayList<>();
        ArrayList<String> operate = new ArrayList<>();
        ArrayList<String> time = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");

        String temp;
        int count = 0;
        double minutes = 0;
        while (day > 0) {
            while (true) {
                num.add(sc.next());
                operate.add(sc.next());
                time.add(sc.next());
                if (num.get(num.size() - 1).equals("0")) {
                    num.remove(num.size() - 1);
                    operate.remove(operate.size() - 1);
                    time.remove(time.size() - 1);
                    break;
                }
            }
            for (int i = 0; i < operate.size(); i++) {
                if (operate.get(i).equals("S")) {
                    temp = num.get(i);
                    for (int j = i + 1; j < operate.size(); j++) {
                        if (operate.get(j).equals("E")) {
                            if (num.get(j).equals(temp)) {
                                count++;
                                Date date1 = sdf.parse(time.get(j));
                                Date date2 = sdf.parse(time.get(i));
                                long l = date1.getTime() - date2.getTime();
                                minutes = minutes + l / 1000.0 / 60.0;
                                break;
                            }
                        }
                    }
                }
            }
            double averageTime;
            if (count == 0) {
                averageTime = 0;
            } else
                averageTime = minutes / count;
            System.out.printf("%d %.0f\n", count, averageTime);

            count = 0;
            minutes = 0;
            num.clear();
            operate.clear();
            time.clear();

            day--;
        }
        sc.close();
    }
}