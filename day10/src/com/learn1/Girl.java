package com.learn1;

public class Girl {
    private String name;
    private int age;

    public Girl() {
    }

    public Girl(String name) {

    }

    public Girl(String name, int age) {
        this(name);

    }

    public void marry(Boy boy) {
        boy.marry(new Girl());
    }

    public void compare(Girl girl) {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
