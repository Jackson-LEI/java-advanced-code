package classTeaching.week8;

import java.util.HashSet;

public class HashSetTask {

    public static void main(String[] args) {
        // ����Begin-End���д����
        /********** Begin **********/
        // ��1������������
        HashSet<Student> set = new HashSet<>();
        // ��2����Student��Ķ�����ӽ�����
        Student s1 = new Student("��Ӣ��", 20208001);
        Student s2 = new Student("����", 20209002);
        Student s3 = new Student("�ܽ���", 20207003);
        Student s4 = new Student("�ഫ��", 20206002);
        Student s5 = new Student("��Ӣ��", 20205004);
        set.add(s1);
        set.add(s2);
        set.add(s3);
        set.add(s4);
        set.add(s5);
        // ��3�����жϼ�����Ԫ�ظ����Ƿ����4
        System.out.print("�����е�Ԫ�ش����Ƿ����4?" + (set.size() > 4));
        // ��5�����жϼ���Ԫ�����Ƿ���ָ�������磺����������Ƽ ��ѧ��֤�ţ�20207073���������ʾ��Ϣ
        System.out.print("������������Ƽ��?" + (set.contains(new Student("����Ƽ", 20207073))));
        // ��6�����������в�����ָ�������磺����Ƽ��20207073��ʱ���Ѹ�Ԫ����ӽ�����
        if (set.contains(new Student("����Ƽ", 20207073))) {
            set.add(new Student("����Ƽ", 20207073));
        }
        // ��7�����Ƴ�ָ���������磺��������Ц ѧ��֤�ţ�20205004�����������ʾ��Ϣ
        System.out.print("�Ƴ�ָ��������Ц" + set.remove(new Student("��Ц", 20205004)));
        // ��8������ӡ����Ԫ��
        set.forEach(System.out::println);
        /********** End **********/
    }
}
