package com.learn;

/**
 * 不使用工厂模式
 * 对象的创建和使用混合在一起
 */
public class NoFactoryTest {
    public static void main(String[] args) {
        AudiCar audiCar = new AudiCar();
        audiCar.drive();

        BydCar bydCar = new BydCar();
        bydCar.drive();
    }
}

class Car {
    public void drive() {
    }
}

class AudiCar extends Car {
    public void drive() {
        System.out.println("开奥迪");
    }
}

class BydCar extends Car {
    public void drive() {
        System.out.println("开比亚迪");
    }
}
