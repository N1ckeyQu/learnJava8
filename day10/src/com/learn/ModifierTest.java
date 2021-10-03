package com.learn;

/**
 * 修饰符的作用范围测试类
 */
public class ModifierTest {
    public static void main(String[] args) {
        //Cat类是default修饰，因此同一个包下可以访问到
        Cat c = new Cat();
        //Cat类中的legs属性由private修饰，因此只有在Cat类内部可以直接访问到，外部无法直接访问
//        c.legs;
    }
}
