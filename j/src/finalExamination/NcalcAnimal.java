package finalExamination;

public class NcalcAnimal {

    public static void main(String[] args) {
        //������������
        for (int ox = 0; ox < 10; ox++) {
            for (int sheep = 0; sheep < 33; sheep++) {
                for (int rabit = 1; rabit < 100; rabit++) {
                    if (ox + sheep + rabit == 100 && ox * 100 + sheep * 30 + rabit * 5 == 1000)
                        System.out.println("Сţ��" + ox + "ֻ����᣺" + sheep + "ֻ��С�ã�" + rabit + "ֻ");
                }
            }
        }

    }

}

