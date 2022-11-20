package classTeaching.week5;

public class Cumulative implements Calculate {

    @Override
    public long calculate(int n) {
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

}
