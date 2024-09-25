package com.demo.takeout.test;


public class ThreadLocalExample {

    // 创建一个ThreadLocal变量
    private static final ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        // 线程安全的打印出当前线程的编号
        new Thread(() -> {
            int threadId = (int) Thread.currentThread().getId();
            threadLocal.set(threadId); // 为当前线程设置ThreadLocal变量
            try {
                Thread.sleep(1000); // 休眠一段时间，以观察输出结果
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread " + threadId + " ID: " + threadLocal.get()); // 打印当前线程的ID
        }).start();

        new Thread(() -> {
            int threadId = (int) Thread.currentThread().getId();
            threadLocal.set(threadId); // 为当前线程设置ThreadLocal变量
            try {
                Thread.sleep(1000); // 休眠一段时间，以观察输出结果
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread " + threadId + " ID: " + threadLocal.get()); // 打印当前线程的ID
        }).start();
    }
}


