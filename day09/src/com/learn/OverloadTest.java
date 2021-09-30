package com.learn;

/**
 * 重载：两同一不同
 * 同一个类、同一个方法名，参数列表不同
 * 为什么一定要求参数列表不同？可以这样想：我们在调用方法时，如果方法名相同、参数列表也相同
 * 那你如何确定你调用的是哪个方法，所以这样的设定是合理的
 */
public class OverloadTest {

    /**
     * 参数列表的顺序不同，也算作重载
     */
    public void test(String s, int i) {

    }

    public void test(int i, String s) {

    }

}
