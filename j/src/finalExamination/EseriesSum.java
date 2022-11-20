package finalExamination;

import java.text.DecimalFormat;
import java.util.Scanner;

public class EseriesSum {

    public static double seriesSum(double b) {
        //数列求和
        if (b == 1) {
            return 1 / 2.0;
        } else {
            return b / (b + 1) + seriesSum(b - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        sc.close();
        DecimalFormat df = new DecimalFormat();
        df.applyLocalizedPattern("0.0000");
        System.out.print(df.format(seriesSum(a)));
    }

}
