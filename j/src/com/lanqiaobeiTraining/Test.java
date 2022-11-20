package com.lanqiaobeiTraining;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(56);
        list.add(9);
        list.add(242);
        list.add(73);
        list.add(90);
        Collections.sort(list);
        System.out.println(list);
    }
}
