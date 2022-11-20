package finalExamination;

public class Fexchange {

    public static void main(String[] args) {
        for (int one = 0; one <= 100; one++) {
            for (int two = 0; two <= 50; two++) {
                for (int five = 0; five <= 20; five++) {
                    if (one + two * 2 + five * 5 == 100) {
                        System.out.println("一分:" + one + ",二分:" + two + ",五分:" + five);
                    }
                }
            }
        }
    }

}
