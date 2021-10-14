package com.learn1;

public class Student extends Person{
    int id;
    @Override
    public void name() {
        super.name();
        System.out.println(super.sex);
        System.out.println();
    }

    public Student() {

    }

    public Student(String name, int sex, int id) {
        super(name, sex);
        this.id = id;
    }
}
