package lanqiaoModelTest;

import java.util.Scanner;

public class GetWater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextInt();
        double t = sc.nextInt();
        sc.close();

        int ans = (int) (t / a);
        if (t % a > 0) {
            ans++;
        }
        System.out.print(ans);
        System.out.println(a);
    }
}