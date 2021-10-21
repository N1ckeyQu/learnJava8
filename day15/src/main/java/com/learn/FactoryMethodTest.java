package com.learn;

/**
 * 工厂方法模式
 *
 * 简单工厂模式的缺陷在于违反了开闭原则，对代码功能的扩展开放，对原有功能的修改关闭
 * 试想一下，如果我们要增加其他品牌的车辆，我们就需要修改CarFactory中的原有代码
 * 如果我们修改的这个方法被50个类调用，我们修改了这个方法，可能需要修改50个类中的代码
 * 假设修改的没什么问题，编译能通过，那原有的项目能正常的跑起来吗？这样的风险我相信大多数人都不愿意接受
 *
 * 工厂方法模式的好处是，遵循开闭原则，如果我们要增加其他品牌的车辆，增加新的工厂类即可，无需修改原有代码
 */
public class FactoryMethodTest {
    public static void main(String[] args) {
        Car bydCar = new BydCarFactory().getCar();
        Car teslaCar = new TeslaCarFactory().getCar();
        bydCar.drive();
        teslaCar.drive();
    }
}

class TeslaCar extends Car {
    @Override
    public void drive() {
        super.drive();
        System.out.println("开特斯拉");
    }
}

interface CarFactoryInterface {
    Car getCar();
}

class BydCarFactory implements CarFactoryInterface {

    public Car getCar() {
        return new BydCar();
    }
}

class TeslaCarFactory implements CarFactoryInterface {

    public Car getCar() {
        return new TeslaCar();
    }
}

class AudiCarFactory implements CarFactoryInterface {

    public Car getCar() {
        return new AudiCar();
    }
}