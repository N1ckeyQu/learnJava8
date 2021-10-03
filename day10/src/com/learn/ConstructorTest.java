package com.learn;

/**
 * 每个类都会默认提供一个无参构造方法
 */
public class ConstructorTest {
    String name;

    public static void main(String[] args) {
        ConstructorTest test = new ConstructorTest();
    }

    /*public void ConstructorTest() {

    }*/

    public void ConstructorTest(String s) {
        name = s;
    }
}
