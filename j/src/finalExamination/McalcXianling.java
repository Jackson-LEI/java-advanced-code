package finalExamination;

public class McalcXianling {

    public static void main(String[] args) {
        //马克思手稿之趣味数学问题
        for (int men = 0; men < 17; men++) {//男人花3先令，总数不超过17
            for (int women = 0; women < 25; women++) {//女人花2先令，总数不超过25
                for (int children = 1; children < 30; children++) {
                    if (men + women + children == 30 && men * 3 + women * 2 + children == 50)
                        //条件判断：总数30人+共花费50先令
                        System.out.println("男人" + men + "，女人" + women + "，小孩" + children);
                }
            }
        }
    }

}
