package finalExamination;

public class CmoneyBuyChicken {

    public static void main(String[] args) {
        //��Ǯ��ټ�
        for (int gong = 0; gong <= 100; gong++) {
            for (int mu = 0; mu <= 100; mu++) {
                for (int chicken = 0; chicken <= 100; chicken += 3) {
                    if (gong + mu + chicken == 100 && gong * 5 + mu * 3 + chicken / 3 == 100) {
                        System.out.println("����" + gong + "ĸ��" + mu + "С��" + chicken);
                    }
                }
            }
        }
    }

}
