package com.learning.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DemoListVisit {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        // 遍历List集合的三种方式
        List l = new ArrayList();
        l.add("jack");
        l.add("tom");
        l.add("marry");
        l.add("jl");
        l.add("kim");

        // 使用迭代器
        Iterator i = l.iterator();
        while (i.hasNext()) {
            Object o = i.next();
            System.out.print(o + " ");
        }
        System.out.println();

        // 使用增强型for循环
        for (Object o : l) {
            System.out.print(o + " ");
        }
        System.out.println();

        // 使用普通for循环
        for (int index = 0; index < l.size(); index++) {
            System.out.print(l.get(index) + " ");
        }

    }

}
