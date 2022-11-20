package com.learning.list;

import java.util.ArrayList;
import java.util.List;

public class DemoListMethod {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List l1 = new ArrayList();
        l1.add("������");
        l1.add("�ֱ���");
        // add()���������ڼ�����index��λ���ϲ���һ��Ԫ��
        l1.add(1, "����");
        System.out.print(l1);

        List l2 = new ArrayList();
        l2.add("jack");
        l2.add("tom");
        l1.addAll(1, l2);
        // addAll()���������ڼ����д�index��λ�ÿ�ʼ��������һ�������е�����Ԫ��
        System.out.println(l1);

        // indexOf()���ض����ڼ������״γ��ֵ�λ��
        System.out.println(l1.indexOf("tom"));

        // indexOf()���ض����ڼ��������һ�γ��ֵ�λ��
        l1.add("����");
        System.out.println(l1);
        System.out.println(l1.lastIndexOf("����"));

        // remove()��������ɾ��ָ��indexλ���ϵ�Ԫ�أ������ش�Ԫ��
        l1.remove(0);
        System.out.println(l1);

        // set()������������ָ��indexλ�õ�Ԫ��Ϊ��һ�������൱���滻
        l1.set(1, "����");// index����������󳤶�ʱ�����׳�indexOutOfBoundException�쳣
        System.out.println(l1);

        // subList()�����ɷ��ش�fromNindex��toIndexλ���ϵ��Ӽ���(����ҿ�)
        List sub = l1.subList(0, 2);
        System.out.print(sub);

    }

}
