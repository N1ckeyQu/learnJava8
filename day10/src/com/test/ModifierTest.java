package com.test;

import com.learn.ProtectedClassTest;
import com.learn1.Boy;

public class ModifierTest extends Boy {
    //ProtectedClassTest和当前类不在同一个包下，但还是能创建该类的实例
    ProtectedClassTest p = new ProtectedClassTest();

    public static void main(String[] args) {
        ModifierTest m = new ModifierTest();

        //protected修饰的方法，可以被不同包中的子类调用
        m.getName();

    }
}
