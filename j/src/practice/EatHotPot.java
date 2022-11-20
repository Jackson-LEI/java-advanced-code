package practice;

import java.util.Scanner;

public class EatHotPot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int index = 0;
        int ans = 0;
        int count = 0;
        boolean flag = true;
        while (true) {
            index++;
            String s = sc.nextLine();
            if (s.equals(".")) {
                flag = false;
                break;
            }
            if (s.contains("chi1 huo3 guo1")) {
                count++;
                ans = index;
                break;
            }
        }

        while (flag) {
            index++;
            String s = sc.nextLine();
            if (s.equals(".")) {
                break;
            }
            if (s.contains("chi1 huo3 guo1")) {
                count++;
            }
        }
        sc.close();

        System.out.println(index - 1);
        if (count == 0) {
            System.out.println("-_-#");
        } else {
            System.out.print(ans + " " + count);
        }

    }
}
