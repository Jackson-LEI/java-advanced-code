package classTeaching.week5;

public class Factorial implements Calculate {

    @Override
    public long calculate(int n) {
        if (n == 0) {
            return 1;
        }
        long sum = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
        }
        return sum;
    }
}
