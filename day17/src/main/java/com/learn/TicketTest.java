package com.learn;

/**
 * 三个窗口卖票
 */
public class TicketTest {
    public static void main(String[] args) {
        Window w = new Window();

        Thread w1 = new Thread(w);
        Thread w2 = new Thread(w);
        Thread w3 = new Thread(w);

        w1.setName("窗口一");
        w2.setName("窗口二");
        w3.setName("窗口三");

        w1.start();
        w2.start();
        w3.start();
    }
}

class Window implements Runnable {
    private int num = 100;

    @Override
    public void run() {
        while (true) {
            if (num > 0) {
                num--;
                System.out.println(Thread.currentThread().getName() + "剩余" + num + "张票");
            } else {
                System.out.println(Thread.currentThread().getName() + "的票卖光啦");
                try {
                    Thread.currentThread().join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
