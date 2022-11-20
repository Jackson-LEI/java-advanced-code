package com.learning.list;

import java.util.ArrayList;
import java.util.List;

public class DemoListMethod {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List l1 = new ArrayList();
        l1.add("张三丰");
        l1.add("贾宝玉");
        // add()方法可以在集合中index的位置上插入一个元素
        l1.add(1, "金雷");
        System.out.print(l1);

        List l2 = new ArrayList();
        l2.add("jack");
        l2.add("tom");
        l1.addAll(1, l2);
        // addAll()方法可以在集合中从index的位置开始，插入另一个集合中的所有元素
        System.out.println(l1);

        // indexOf()返回对象在集合中首次出现的位置
        System.out.println(l1.indexOf("tom"));

        // indexOf()返回对象在集合中最后一次出现的位置
        l1.add("金雷");
        System.out.println(l1);
        System.out.println(l1.lastIndexOf("金雷"));

        // remove()方法可以删除指定index位置上的元素，并返回此元素
        l1.remove(0);
        System.out.println(l1);

        // set()方法可以设置指定index位置的元素为另一个对象，相当于替换
        l1.set(1, "玛丽");// index超出集合最大长度时，将抛出indexOutOfBoundException异常
        System.out.println(l1);

        // subList()方法可返回从fromNindex到toIndex位置上的子集合(左闭右开)
        List sub = l1.subList(0, 2);
        System.out.print(sub);

    }

}
