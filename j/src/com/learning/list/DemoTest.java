package com.learning.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DemoTest {
    /*
     * Test:ʵ�����¹���: ���10�����ϵ�Ԫ��(����String "Hello")���ڶ���λ���ϲ���һ��Ԫ��"����"��
     * ��õ����Ԫ�أ�ɾ��������Ԫ�أ��޸ĵ��߸�Ԫ�أ���ʹ�õ������������ϣ� ʹ��Listʵ�ֵ���ArrayList��ɡ�
     */
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List l = new ArrayList();
        for (int i = 0; i < 12; i++) {
            l.add("Hello" + i);
        }
        System.out.println(l);

        l.add(1, "����");
        System.out.println(l.get(4));
        l.remove(5);
        l.set(6, "Hello");

        Iterator i = l.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }

    }

}
