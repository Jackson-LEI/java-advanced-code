package classTeaching.week8;

import java.util.Scanner;
import java.util.TreeMap;

public class TreeMapTest {

    public static void main(String[] args) {
        // ����Begin-End���д����
        /********** Begin **********/

        // ��1�������ո����ַ���
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        // ��2��������TreeMap���ϣ�keyΪѧ����ţ�valueΪѧ������
        TreeMap<Integer, String> map = new TreeMap<>();
        // ��3�����и��ַ���
        String[] arr = s.split("��");
        // ��4������Ԫ����ӵ�������
        for (int i = 0; i < arr.length; i++) {
            map.put(Integer.valueOf(arr[i].substring(0, arr[i].indexOf("��"))),
                    arr[i].substring(arr[i].indexOf("��") + 1));
        }
        // ��5���������������ѧ�����
        System.out.println("�������:" + map.descendingKeySet());
        // ��6�������ѧ�����������С��Ԫ��
        System.out.println("ѧ������Ԫ��:" + map.lastEntry());
        System.out.println("ѧ����С��Ԫ��:" + map.firstEntry());

        // ��7����ɾ��ѧ�������С��Ԫ��
        System.out.println("ɾ��ѧ����С��Ԫ��:" + map.pollFirstEntry());
        //��8������ӡ����

        System.out.println(map.toString().replace("=", "��"));
        /********** End **********/
    }
}
