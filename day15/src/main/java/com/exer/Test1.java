package com.exer;

public class Test1 {

}

interface A {
    int x = 0;
}

class B {
    int x = 1;
}

class C extends B implements A {
    public void pX() {
        System.out.println(A.x);
        System.out.println(super.x);
    }

    public static void main(String[] args) {
        new C().pX();
    }
}