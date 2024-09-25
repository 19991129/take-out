package com.demo.takeout.test;

public class Test {

    public static void main(String[] args) {
        Thread thread1 = new Thread(Test::printNumbers, "小明");
        Thread thread2 = new Thread(Test::printNumbers, "小华");
        thread1.start();
        thread2.start();
    }
    private static void printNumbers() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);

            // 当 i 是偶数时，当前线程暂停执行
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + " 让出控制权...");
                Thread.yield();
            }
        }
    }
}
