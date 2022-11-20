package com.learning.collection;

import com.learning.Book;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DemoIterator {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        // �������������϶���

        List l = new ArrayList();
        l.add(new Book("��������", "�޹���", 10.1));
        l.add(new Book("С��ɵ�", "����", 5.1));
        l.add(new Book("��¥��", "��ѩ��", 34.6));

        Iterator i = l.iterator();
        // ʹ��Collection�����iterator()������ȡ��������Iterator����i��ʼ��
        while (i.hasNext()) {// �жϼ��϶������Ƿ���Ԫ��
            Object o = i.next();
            // Iterator�����next()������ȡ��һ��Ԫ�أ��������ŵ�����o��
            System.out.println(o);
        }

        /*
         * �������������Ѿ�ָ�򼯺������һ��Ԫ��ʱ�����������ƶ�ָ��ʱ��(i.next();)
         * ����û�����ݣ����׳�NoSuchElementException�쳣����ʱ��Ҫ���õ���������
         */
        i = l.iterator();
        System.out.println("���������������������������������������ڶ��Ρ�������������������������������������");
        while (i.hasNext()) {
            Object o = i.next();
            System.out.println(o);
        }

        // ��ǿ��forѭ����������

        for (Object book : l) {
            System.out.println(book);
        }
        // ����ʹ��Iterator�������������ϵ���Ч�������ǿ��forѭ���ײ���Ȼ������Iterator��

    }

}
