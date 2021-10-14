package com.learn;

public class Person {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize方法被调用了: " + this);
    }
}
