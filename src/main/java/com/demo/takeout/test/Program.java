package com.demo.takeout.test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Program {
    public static void main(String[] args) {//主线程
        System.out.println(
                LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS")) + "-" +
                        Thread.currentThread().getName());
    }
}
