package com.learn;

/**
 * 使用runnable创建线程
 * 类实现runnable接口，重写run方法
 * new Thread类，将runnable接口的实现类作为参数传入
 * 调用start方法
 */
public class ThreadTest1 {
    public static void main(String[] args) {
        Thread t = new Thread(new RunnableTest());
        t.start();
    }
}

class RunnableTest implements Runnable {

    @Override
    public void run() {
        System.out.println("使用runnable创建线程");
    }
}
