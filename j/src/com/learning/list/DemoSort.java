package com.learning.list;

import com.learning.Book;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"all"})
public class DemoSort {

    public static void main(String[] args) {
        // 对集合使用冒泡排序，按价格从小到大排序
        List l = new ArrayList();
        l.add(new Book("三国演义", "罗贯中", 100));
        l.add(new Book("小李飞刀", "古龙", 10));
        l.add(new Book("红楼梦", "曹雪芹", 19));
        l.add(new Book("西游记", "吴承恩", 80));

        for (Object o : l) {
            System.out.println(o);
        }

        sort(l);
        System.out.println("排序后:");
        for (Object o : l) {
            System.out.println(o);
        }

    }

    public static void sort(List l) {// 冒泡排序
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
