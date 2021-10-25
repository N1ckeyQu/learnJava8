package com.exer;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个用户往同一个账户中存3000元，每次存1000，存三次。每次存完打印账户余额
 */
public class AccountTest {
    private ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        //存钱的账户
        Account account = new Account();
        //两个用户
        Customer2 c1 = new Customer2();
        Customer2 c2 = new Customer2();

        c1.setAccount(account);
        c2.setAccount(account);


    }
}

class Account {
    private int num;

}

class Customer2 implements Runnable {
    private Account account;

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public void run() {

    }
}
