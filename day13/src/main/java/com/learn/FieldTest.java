package com.learn;

public class FieldTest {
    final int i;

    public FieldTest() {
        i = 3;
    }

    public final void lala() {
        System.out.println("lala");
    }

    public static void main(String[] args) {
        FieldTest fieldTest = new FieldTest();
        System.out.println(fieldTest.i);



    }
}
