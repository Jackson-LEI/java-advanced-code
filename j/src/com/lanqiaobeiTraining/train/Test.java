package com.lanqiaobeiTraining.train;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Test {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.set(2022, Calendar.APRIL, 16);
        c.add(Calendar.DAY_OF_YEAR, 19673);
        System.out.println(c.get(Calendar.DAY_OF_YEAR));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(c.getTime()));
    }
}