package com.learn1;

public class PersonTest {
    private String name;
    private int age;

    public static void main(String[] args) {
        PersonTest p = new PersonTest();
        p.study();
    }

    public PersonTest(){

    }

    public void eat() {
        System.out.println("人吃饭");
    }

    public void study() {
        eat();
        System.out.println("人学习");
    }

    public String getName() {
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
