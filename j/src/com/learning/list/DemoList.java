package com.learning.list;

import java.util.ArrayList;
import java.util.List;

public class DemoList {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List l = new ArrayList();
        // ʵ����List�ӿڵļ��ϣ�Ԫ�ص����˳����ȡ����˳��һ�£��ҿ��ظ�
        l.add("jack");
        l.add("tom");
        l.add("marry");
        l.add("hsp");
        l.add("hsp");
        System.out.print(l);

        // List������ÿһ��Ԫ�ض������Ӧ��˳����������0��ʼ
        System.out.print(l.get(3));

        // ArrayListע������

        // ArrayList
    }
}
