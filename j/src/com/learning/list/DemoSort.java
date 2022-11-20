package com.learning.list;

import com.learning.Book;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"all"})
public class DemoSort {

    public static void main(String[] args) {
        // �Լ���ʹ��ð�����򣬰��۸��С��������
        List l = new ArrayList();
        l.add(new Book("��������", "�޹���", 100));
        l.add(new Book("С��ɵ�", "����", 10));
        l.add(new Book("��¥��", "��ѩ��", 19));
        l.add(new Book("���μ�", "��ж�", 80));

        for (Object o : l) {
            System.out.println(o);
        }

        sort(l);
        System.out.println("�����:");
        for (Object o : l) {
            System.out.println(o);
        }

    }

    public static void sort(List l) {// ð������
        int listsize = l.size();
        for (int i = 1; i < listsize - 1; i++) {
            for (int j = 0; j < listsize - i; j++) {
                Book b1 = (Book) l.get(j);
                Book b2 = (Book) l.get(j + 1);
                if (b1.getPrice() > b2.getPrice()) {
                    l.set(j, b2);
                    l.set(j + 1, b1);
                }
            }
        }
    }

}
