package finalExamination;

public class Oball {

    public static void main(String[] args) {
        for (int red = 0; red <= 3; red++) {
            for (int white = 0; white <= 3; white++) {
                for (int black = 0; black <= 6; black++) {
                    if (black + white + red == 8) {
                        System.out.println("ºìÉ«:" + red + ",°×É«:" + white + ",ºÚÉ«:" + black);
                    }
                }
            }
        }

    }

}
