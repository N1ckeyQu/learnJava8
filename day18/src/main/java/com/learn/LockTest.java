package com.learn;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用Lock来解决线程安全问题
 *
 * 面试题：synchronized和lock的异同点
 * 相同：都可以解决线程安全问题
 * 不同：synchronized机制在执行完同步代码后，自动释放同步监视器；而lock需要手动的调用lock()和unlock()方法
 *      lock只能锁一段代码，而synchronized除了可以同步代码块，还可以同步方法
 *      使用lock锁，JVM将花费较少的时间来调度线程，性能更好。并且具有更好的扩展性（提供更多的子类）
 *
 *  开发中的使用优先级：lock > 同步代码块 > 同步方法
 */
public class LockTest {
    public static void main(String[] args) {
        Window w = new Window();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口一：");
        t2.setName("窗口二：");
        t3.setName("窗口三：");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window implements Runnable {

    private int num = 100;

    //入参默认是false，即非公平模式
    private ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true) {
            try {
                //调用锁定方法lock
                lock.lock();

                if (num > 0) {
                    System.out.println(Thread.currentThread().getName() + "卖出了第" + num + "张票");
                    num --;

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            } finally {
                //调用解锁方法unlock
                lock.unlock();
            }
        }
    }
}
