package com.learn;

public class AbstractTest {
    public static void main(String[] args) {
        Person p = new Person() {
            @Override
            public void sum() {
                System.out.println("lala");
            }
        };

        Fly f = new Fly() {
            @Override
            public void fly() {
                System.out.println("飞翔");
            }
        };

        f.fly();
    }
}

interface Fly {
    void fly();
}

abstract class Person {
    String name;
    int age;

    public abstract void sum();
}