package lanqiaoModelTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Nine {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Long> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(sc.nextLong());
        }
        sc.close();

        long count = 0;
        long max = Collections.max(list);
        long a = list.get(0);
        long b = list.get(1);
        long c = list.get(2);
        for (long i = 1; i <= max; i++) {
            if (a % i == 0 && b % i == 0) {
                count++;
//				System.out.println(i);
            } else if (a % i == 0 && c % i == 0) {
                count++;
//				System.out.println(i);
            } else if (b % i == 0 && c % i == 0) {
                count++;
//				System.out.println(i);
            }
        }
        System.out.println(count);
    }

}
