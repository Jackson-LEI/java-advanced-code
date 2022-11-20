package classTeaching.week8;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTask {
    public static void main(String[] args) {
        // ����Begin-End���д����
        /********** Begin **********/
        // ��1������������
        TreeSet<Student> set = new TreeSet<>();
        // ��2����Student��Ķ�����ӽ�����
        set.add(new Student("��Ӣ��", 20208001));
        set.add(new Student("����", 20209002));
        set.add(new Student("�ܽ���", 20207003));
        set.add(new Student("��Ц", 20205004));
        set.add(new Student("�ഫ��", 20206002));

        //��3������ѧ������˳���ӡѧ����Ϣ
        System.out.println("�������:");
        Iterator<Student> i = set.descendingIterator();//Ҳ����ʹ��set.descendingSet()
        while (i.hasNext()) {
            System.out.println(i.next());
        }
        //��4���� ���ѧ����С��ѧ����Ϣ
        System.out.println("ѧ����С��ѧ��:" + set.first());
        //��5���� ���ѧ������ѧ����Ϣ
        System.out.println("ѧ������ѧ��:" + set.last());
        //��6���� �Ƴ�ѧ����С��ѧ����Ϣ
        System.out.println("�Ƴ�ѧ����С��ѧ��:" + set.pollFirst());
        //��7���� �Ƴ�ѧ������ѧ����Ϣ
        System.out.println("�Ƴ�ѧ������ѧ��:" + set.pollLast());
        // ��8������ӡ����Ԫ��
        System.out.println("ѧ��\t����\n---------------------");
        set.forEach(System.out::println);
    }
}
