package lanqiaoModelTest;

import java.util.Scanner;

public class Two {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();

        String ans = s.replaceAll(",", "");
        long longValue = Long.parseLong(ans.substring(0, ans.indexOf(".")));
        String smallValue = ans.substring(ans.indexOf("."));
        System.out.print(longValue + smallValue);
    }
}
