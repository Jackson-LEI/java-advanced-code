package com.learning.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DemoTest {
    /*
     * Test 1:实现以下功能： 1.创建3个Dog{name, age}对象，放到ArrayList中 2.用迭代器和增强型for循环两种方式遍历集合
     * 3.重写Dog的toString方法，将name和age输出
     */
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List l = new ArrayList();
        l.add(new Dog("金毛", 3));
        l.add(new Dog("贵宾犬", 5));

        Iterator i = l.iterator();
        while (i.hasNext()) {
            Object o = i.next();
            System.out.println(o);
        }

        System.out.println("———————————————————————————");

        for (Object o : l) {
            System.out.println(o);
        }
    }
}

class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog [name=" + name + ", age=" + age + "]";
    }

}
