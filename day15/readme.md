# day15 学习

## Java8 接口的新特性

新增加了**静态方法和默认方法**，这两种方法都是有方法体的。接口名.静态方法名就可以直接调用，实际开发中没怎么见过。默认方法的调用方式很简单，创建子类对象后直接调用就行，前提是子类没有重写接口中的默认方法

这两个新特性，默认方法用的更多些。假设接口已经被很多类实现了，此时我们想要扩充接口的功能，就需要改写很多类去实现在接口中新添加的抽象方法，如果我们不想这样做，默认方法就是个比较好的解决方法，在接口中定义默认方法，然后再去重写就行

这两个新特性的加入，让接口变得更加像是类了

### 类优先原则

类A继承了类B，实现了接口C，如果B和C中都有同名同参数的方法x，此时类A的实例化对象调用该方法x，它调用的是哪个方法？

根据类优先原则，它调用的应当是父类中的方法x（前提是类A中没有重写类B的方法x）

## 代理模式

```java
package com.learn;

/**
 * 接口的应用——代理模式
 */
public class NetworkTest {
    public static void main(String[] args) {
        ProxyServer proxyServer = new ProxyServer(new Server());
        proxyServer.browse();
    }
}

interface Network {
    void browse();
}

/**
 * 被代理类
 */
class Server implements Network {

    public void browse() {
        System.out.println("真实的server访问网络");
    }

}

/**
 * 代理类
 */
class ProxyServer implements Network {

    private Network network;

    public ProxyServer(Network network) {
        this.network = network;
    }

    public void check() {
        System.out.println("联网之前的检查工作");
    }

    public void browse() {
        check();
        network.browse();
    }
}
```

- 代理类和被代理类实现同一接口
- 代理类中声明有参构造器，形参为代理类和被代理类共同实现的接口
- 代理类中实现的要执行的方法，必然是增强过的逻辑

具体执行的时候，创建代理类对象，把被代理类的实例传入即可，让代理类来执行这个方法，这就是代理模式的简单实现

## 无工厂模式

```java
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
```

对象的创建和使用混合在一起，程序的耦合程度高

## 简单工厂模式

```java
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
```

用户不用关心对象创建的过程，工厂创建完成直接拿来用就行，更符合面向对象编程的封装性

## 工厂方法模式

```java
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
```

