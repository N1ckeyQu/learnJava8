package com.learn;

/**
 * 单例模式——双重检查
 * 实现同步有好几种方式，这种效率好一点
 */
public class SingletonTest {

}

class Singleton {
    private static Singleton instance = null;

    private Singleton() {

    }

    /**
     * 其实这里可以不加static，算是一种约定俗成的规范吧，如果一个方法内部包含静态变量的相关操作
     * 那么我们通常也将该方法声明成静态的
     */
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
