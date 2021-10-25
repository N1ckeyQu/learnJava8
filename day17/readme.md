# day17 学习

## 对程序、进程、线程的理解

程序就是使用编程语言写的一组指令集，它是**静态**的。当我们的程序开始运行，计算机会为程序开一个进程，**正在运行的程序就是进程**，比如我们打开软件A，它具有功能1，2，3。我们可以同时使用这三个功能，此时三个线程会分别运行这三个功能。线程的粒度要比进程更小

## 代码完成继承Thread的方式创建分线程，并遍历100以内的自然数

```java
package com.learn;

/**
 * 创建线程的方式一：
 * 创建一个继承Thread类的子类
 * 重写run方法
 * 实例化子类对象
 * 对象.start()
 * <p>
 * eg：遍历100以内的所有偶数
 */
public class ThreadTest {
    public static void main(String[] args) {
        Test1 t1 = new Test1();
        t1.start();

        Test2 t2 = new Test2();
        t2.start();
    }
}

class Test1 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i < 101; i++) {
            if (i % 2 == 0) {
                System.out.println(getName() + ":" + i);
            }

            if (i % 10 == 0) {
                //释放当前线程的执行权，重新回到线程争抢CPU资源的阶段
                yield();
            }

            if (i == 20) {
                try {
                    System.out.println(isAlive());
                    join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Test2 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i < 101; i++) {
            if (i % 2 != 0) {
                System.out.println(getName() + ":" + i);
            }
        }
    }
}

```

## 代码完成实现Runnable接口的方式创建分线程，并遍历100以内的自然数

```java
package com.learn;

/**
 * 使用runnable创建线程
 * 类实现runnable接口，重写run方法
 * new Thread类，将runnable接口的实现类作为参数传入
 * 调用start方法
 */
public class ThreadTest1 {
    public static void main(String[] args) {
        Thread t = new Thread(new RunnableTest());
        t.start();
    }
}

class RunnableTest implements Runnable {

    @Override
    public void run() {
        System.out.println("使用runnable创建线程");
    }
}
```

## 对比实现多线程的两种方式

在Java中对于类是单继承的，因此如果我们使用继承Thread类的方式创建多线程，它只能继承Thread类，但是实际开发中很有可能是需要继承其它类的，这是局限性之一

如果我们使用实现Runnable接口的方式创建多线程，我们在操作共享数据的时候就会方便一些，只需要一个实现类对象

再谈源码，Thread类实现了Runnable接口，所以我们使用继承Thread的方式去重写run方法，实际上也是在重写Runnable接口中的run方法

综上所述，在开发中优先使用实现Runnable接口的方式创建多线程

## 对IDEA中project和module的理解

project就代表着一个项目，一个项目会有很多业务模块，以及一些公共的工具类，它们分别属于不同的模块下，但它们都属于同一个project

