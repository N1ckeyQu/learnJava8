package com.exer;

public class Test3 {
    public static void main(String[] args) {
        new AbstractTest() {
            void method() {

            }
        };
    }
}

abstract class AbstractTest {
    abstract void method();
}

