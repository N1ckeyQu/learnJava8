package com.learn;

/**
 *
 */
public class StaticTest {
    public static void main(String[] args) {
        Chinese c1 = new Chinese();
        c1.name = "姚明";
        c1.age = 41;

        Chinese c2 = new Chinese();
        c2.name = "马龙";
        c2.age = 30;

        c1.nation = "中国";

        //证明了static关键字修饰的结构，是属于这个类的，而不属于这个对象
        System.out.println(c2.nation);

    }

}

class Chinese {
    String name;
    int age;
    static String nation;
}