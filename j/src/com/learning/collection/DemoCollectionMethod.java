package com.learning.collection;

import java.util.ArrayList;
import java.util.List;

public class DemoCollectionMethod {
    @SuppressWarnings({"all"})
    // SuppressWarnings��ע���Ը��߱���������������еľ��汣�־�Ĭ
    public static void main(String[] args) {
        // Collection�෽��

        List l = new ArrayList();
        // ʹ��List�ഴ������l��ʹ��List������ArrayList������ʵ����

        // add()���������򼯺�����ӵ���Ԫ��
        l.add("jack");
        l.add(10);
        l.add(true);
        /*
         * add()�����д�����һ��Object���͵Ĳ�����Ҳ����˵����ӵ����������һ����װ���Ķ��� �����ǻ�����������(�Զ�װ��)����ͬ�� l.add(new
         * Integer(10)); l.add(new Boolean(true));
         */
        System.out.println(l);// ������д��toString()����

        // remove()��������ɾ��������ĵ���Ԫ��
        // ɾ���Ŀ�����һ������Ҳ������һ���±�(remove()����������)
        l.remove(0);// ɾ��l���±�Ϊ0��Ԫ��
        l.remove("jack");// ɾ������Ϊ��jack����Ԫ��
        System.out.println(l);

        // contains()���������ж�Ԫ���Ƿ����
        System.out.println(l.contains(true));

        // size()�������Ի�ȡԪ�ظ���
        System.out.println(l.size());

        // isEmpty()���������ж������Ƿ�Ϊ��
        System.out.println(l.isEmpty());

        // clear()���������������
        l.clear();
        System.out.println(l);

        // addAll()����������Ӷ��Ԫ��
        List l1 = new ArrayList();
        l1.add("��¥��");
        l1.add("��������");
        l.addAll(l1);

        // containsAll()���������ж϶��Ԫ���Ƿ���ڣ����ݵĲ���ֻ����һ��collection����
        System.out.println(l.containsAll(l1));

        // removeAll()��������ɾ�����Ԫ�أ����ݵĲ���ֻ����һ��collection����
        l.add("��ի");
        l.removeAll(l1);// ��l��ɾ����l1����ͬ��Ԫ��
        System.out.println(l);
    }

}
