package com.learn;

import org.apache.commons.lang3.StringUtils;

/**
 * 使用简单工厂模式
 * 将对象的创建和使用进行分离
 * 降低代码耦合度
 * 同时也不需要用户关心对象创建的过程，工厂创建完成直接拿来用就行，更符合面向对象编程的封装性
 */
public class SimpleFactoryTest {
    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
        Car audiCar = carFactory.getCar("奥迪");
        Car bydCar = carFactory.getCar("比亚迪");
        audiCar.drive();
        bydCar.drive();
    }
}

class CarFactory {
    /**
     * 这里为了举例方便，因此getCar的逻辑并不复杂，实际情况下生成对象的逻辑可能会很复杂
     * 因此getCar方法帮调用者屏蔽了很多无关的逻辑
     *
     * @param carName
     * @return
     */
    public Car getCar(String carName) {
        if (StringUtils.equals(carName, "奥迪")) {
            return new AudiCar();
        } else if (StringUtils.equals(carName, "比亚迪")) {
            return new BydCar();
        } else {
            return null;
        }
    }
}
