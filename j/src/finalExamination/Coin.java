package finalExamination;

public class Coin {

    public static void main(String[] args) {
        for (int yi = 0; yi <= 100; yi++) {
            for (int er = 0; er <= 50; er++) {
                for (int wu = 0; wu <= 20; wu++) {
                    if (yi + er * 2 + wu * 5 == 100) {
                        System.out.println("1·Ö:" + yi + ",2·Ö:" + er + ",5·Ö:" + wu);
                    }
                }
            }
        }
    }

}
