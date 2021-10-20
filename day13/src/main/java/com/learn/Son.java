package com.learn;

class Father {
    static {
        System.out.println("1");
    }

    {
        System.out.println("2");
    }

    public Father() {
        System.out.println("3");
    }
}

public class Son extends Father{
    static {
        System.out.println("4");
    }

    {
        System.out.println("5");
    }

    public Son() {
        System.out.println("6");
    }

    public static void main(String[] args) {
        System.out.println("7");
        System.out.println("*************");
        //1 4 7 * 2 3 5 6
        new Son();
        System.out.println("*************");
        //2 3 5 6
        new Son();
        System.out.println("*************");
        //2 3
        new Father();
    }
}
