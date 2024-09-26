package com.demo.takeout.test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {//主线程

        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("2");
        for (int i=0; i<list.size(); i++) {
            if ("2".equals(list.get(i))) {
                list.remove(i);
                i--;
            }
        }
        System.out.println(list);

        System.out.println(
                LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS")) + "-" +
                        Thread.currentThread().getName());
    }
}
