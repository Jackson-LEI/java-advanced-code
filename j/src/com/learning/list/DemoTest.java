package com.learning.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DemoTest {
    /*
     * Test:实现以下功能: 添加10个以上的元素(比如String "Hello")，在二号位置上插入一个元素"金雷"，
     * 获得第五个元素，删除第六个元素，修改第七个元素，再使用迭代器遍历集合， 使用List实现的类ArrayList完成。
     */
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List l = new ArrayList();
        for (int i = 0; i < 12; i++) {
            l.add("Hello" + i);
        }
        System.out.println(l);

        l.add(1, "金雷");
        System.out.println(l.get(4));
        l.remove(5);
        l.set(6, "Hello");

        Iterator i = l.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }

    }

}
