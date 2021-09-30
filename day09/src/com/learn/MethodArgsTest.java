package com.learn;

import java.util.Arrays;

/**
 * 可变个数的形参（JDK 5.0之后的新特性）
 * 以前的写法是：String[] args，现在是String... args，省去了创建数组的步骤
 * 注意：1、老写法和新写法无法共存
 *      2、由于args形参没有限制个数，所以需要把args放在形参的最后一位，不然编译器会报错
 *      3、方法参数中只能包含一个可变形参
 *      4、和老写法（数组）不兼容
 */
public class MethodArgsTest {
    public void show(int i) {

    }

    /*public void show(String s) {

    }*/

    /**
     * JDK 5.0之后新加入的写法
     * @param args
     */
    public void show(String... args) {
        System.out.println(Arrays.toString(Arrays.stream(args).toArray()));
    }

    /**
     * 老的写法和新写法无法共存
     * @param args
     */
    /*public void show(String[] args) {
        System.out.println(Arrays.toString(args));
    }*/

    public static void main(String[] args) {
        MethodArgsTest methodArgsTest = new MethodArgsTest();
        methodArgsTest.show("lala");
        methodArgsTest.show("lala", "lala1");
        methodArgsTest.show("lala", "lala2", "lala1");
    }

}
