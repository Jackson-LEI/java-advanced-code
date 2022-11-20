package finalExamination;

public class NcalcAnimal {

    public static void main(String[] args) {
        //王大妈卖牲畜
        for (int ox = 0; ox < 10; ox++) {
            for (int sheep = 0; sheep < 33; sheep++) {
                for (int rabit = 1; rabit < 100; rabit++) {
                    if (ox + sheep + rabit == 100 && ox * 100 + sheep * 30 + rabit * 5 == 1000)
                        System.out.println("小牛：" + ox + "只，羊羔：" + sheep + "只，小兔：" + rabit + "只");
                }
            }
        }

    }

}

