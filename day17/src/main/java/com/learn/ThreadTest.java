package com.learn;

/**
 * 创建线程的方式一：
 * 创建一个继承Thread类的子类
 * 重写run方法
 * 实例化子类对象
 * 对象.start()
 * <p>
 * eg：遍历100以内的所有偶数
 */
public class ThreadTest {
    public static void main(String[] args) {
        Test1 t1 = new Test1();
        t1.start();

        Test2 t2 = new Test2();
        t2.start();
    }
}

class Test1 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i < 101; i++) {
            if (i % 2 == 0) {
                System.out.println(getName() + ":" + i);
            }

            if (i % 10 == 0) {
                //释放当前线程的执行权，重新回到线程争抢CPU资源的阶段
                yield();
            }

            if (i == 20) {
                try {
                    System.out.println(isAlive());
                    join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Test2 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i < 101; i++) {
            if (i % 2 != 0) {
                System.out.println(getName() + ":" + i);
            }
        }
    }
}
