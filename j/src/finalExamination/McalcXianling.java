package finalExamination;

public class McalcXianling {

    public static void main(String[] args) {
        //���˼�ָ�֮Ȥζ��ѧ����
        for (int men = 0; men < 17; men++) {//���˻�3�������������17
            for (int women = 0; women < 25; women++) {//Ů�˻�2�������������25
                for (int children = 1; children < 30; children++) {
                    if (men + women + children == 30 && men * 3 + women * 2 + children == 50)
                        //�����жϣ�����30��+������50����
                        System.out.println("����" + men + "��Ů��" + women + "��С��" + children);
                }
            }
        }
    }

}
