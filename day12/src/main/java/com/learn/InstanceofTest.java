package com.learn;

public class InstanceofTest {
    public static void main(String[] args) {
        Person p1 = new Man();
        Woman woman = new Woman();
        /*
         * 调用子类中特有结构，需要向下转型
         */
        if (p1 instanceof Man) {
            Man man = (Man) p1;
            man.smoking();
        }
    }
}
