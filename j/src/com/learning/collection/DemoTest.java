package com.learning.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DemoTest {
    /*
     * Test 1:ʵ�����¹��ܣ� 1.����3��Dog{name, age}���󣬷ŵ�ArrayList�� 2.�õ���������ǿ��forѭ�����ַ�ʽ��������
     * 3.��дDog��toString��������name��age���
     */
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List l = new ArrayList();
        l.add(new Dog("��ë", 3));
        l.add(new Dog("���Ȯ", 5));

        Iterator i = l.iterator();
        while (i.hasNext()) {
            Object o = i.next();
            System.out.println(o);
        }

        System.out.println("������������������������������������������������������");

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
