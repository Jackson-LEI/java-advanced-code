package com.learning.list;

import java.util.ArrayList;
import java.util.List;

public class DemoList {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List l = new ArrayList();
        // 实现了List接口的集合，元素的添加顺序与取出的顺序一致，且可重复
        l.add("jack");
        l.add("tom");
        l.add("marry");
        l.add("hsp");
        l.add("hsp");
        System.out.print(l);

        // List集合中每一个元素都有其对应的顺序索引，从0开始
        System.out.print(l.get(3));

        // ArrayList注意事项

        // ArrayList
    }
}
