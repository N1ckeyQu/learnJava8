package com.exer;

public class Test1 {
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                this.setName("lala");
                System.out.println(getName());
            }
        }.start();
    }
}