package com.learning.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DemoListVisit {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        // ����List���ϵ����ַ�ʽ
        List l = new ArrayList();
        l.add("jack");
        l.add("tom");
        l.add("marry");
        l.add("jl");
        l.add("kim");

        // ʹ�õ�����
        Iterator i = l.iterator();
        while (i.hasNext()) {
            Object o = i.next();
            System.out.print(o + " ");
        }
        System.out.println();

        // ʹ����ǿ��forѭ��
        for (Object o : l) {
            System.out.print(o + " ");
        }
        System.out.println();

        // ʹ����ͨforѭ��
        for (int index = 0; index < l.size(); index++) {
            System.out.print(l.get(index) + " ");
        }

    }

}
