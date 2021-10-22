package com.learn;

public class InnerClassTest {
    public void method() {
        int num = 10;

        class A {
            public void show() {
                System.out.println(num);
//                num ++;
            }
        }
    }
}
