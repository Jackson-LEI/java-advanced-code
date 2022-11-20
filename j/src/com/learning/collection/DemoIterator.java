package com.learning.collection;

import com.learning.Book;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DemoIterator {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        // 迭代器遍历集合对象

        List l = new ArrayList();
        l.add(new Book("三国演义", "罗贯中", 10.1));
        l.add(new Book("小李飞刀", "古龙", 5.1));
        l.add(new Book("红楼梦", "曹雪芹", 34.6));

        Iterator i = l.iterator();
        // 使用Collection对象的iterator()方法获取迭代器将Iterator对象i初始化
        while (i.hasNext()) {// 判断集合对象里是否还有元素
            Object o = i.next();
            // Iterator对象的next()方法获取下一个元素，并将其存放到对象o中
            System.out.println(o);
        }

        /*
         * 当迭代器对象已经指向集合中最后一个元素时，继续向下移动指针时，(i.next();)
         * 由于没有数据，会抛出NoSuchElementException异常，这时需要重置迭代器对象
         */
        i = l.iterator();
        System.out.println("———————————————————第二次———————————————————");
        while (i.hasNext()) {
            Object o = i.next();
            System.out.println(o);
        }

        // 增强型for循环遍历集合

        for (Object book : l) {
            System.out.println(book);
        }
        // 这是使用Iterator对象来遍历集合的有效替代，增强型for循环底层仍然调用了Iterator类

    }

}
