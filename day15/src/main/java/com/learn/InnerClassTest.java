package com.learn;

public class InnerClassTest {
    public static void main(String[] args) {
        //静态成员内部类的实例化
        Person.Brain brain = new Person.Brain();
        brain.think();

        //非静态成员内部类的实例化
        Person p = new Person();
        Person.Dog dog = p.new Dog();

    }
}

class Person {
    String name;
    int age;

    //静态成员内部类
    static class Brain {
        public void think() {
            System.out.println("思考中");
        }
    }

    //非静态成员内部类
    class Dog {
        String name;
        public void eat() {
            System.out.println("啃骨头");
            //调用外部类的方法
            Person.this.eat();
        }

        public void display(String name) {
            System.out.println(name);
            System.out.println(this.name);
            System.out.println(Person.this.name);
        }
    }

    public void eat() {
        System.out.println("吃狗肉");
    }
}