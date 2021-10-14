package com.exer;

import com.learn.Man;
import com.learn.Person;

public class DuotaiExer {
    public static void main(String[] args) {
        Man man = new Man();
        Person p1 = man;
        System.out.println(man == p1);

        System.out.println(new Person().getClass().getSuperclass());

        p1 = null;
        Runtime.getRuntime().gc();

        Person p2 = new Person();
        Person p3 = new Person();
        //false，原生的equals方法，比较的是地址值
        System.out.println(p2.equals(p3));

        String s1 = "abc";
        String s2 = "abc";
        //true，String类重写了equals方法，比较的是字符串的内容
        System.out.println(s1.equals(s2));

        char c = 12;
        System.out.println(c == 12);

        String s3 = new String("lala");
        String s4 = new String("lala");
        System.out.println(s3 == s4);

        String s5 = "lala";
        String s6 = "lala";
        System.out.println(s5 == s6);

    }
}
