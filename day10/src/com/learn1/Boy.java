package com.learn1;

public class Boy {
    private String name;
    private int age;

    public void marry(Girl girl) {
        System.out.println("我想娶："+girl.getName());
    }

    public void shout() {
        if (age >= 22) {
            System.out.println("你可以合法登记结婚了");
        }
    }

     protected String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
