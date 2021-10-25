package com.learn;

/**
 * 线程通信
 *
 * 线程1和线程2交替打印1~100
 */
public class ThreadCommunicationTest {
    public static void main(String[] args) {
        Number num = new Number();

        Thread t1 = new Thread(num);
        Thread t2 = new Thread(num);

        t1.start();
        t2.start();
    }
}

class Number implements Runnable {
    private int i = 1;
    @Override
    public void run() {
        while (true) {
            synchronized (Number.class) {
                if (i < 101) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "打印：" + i);
                    i++;

                    try {
                        //线程阻塞
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}
