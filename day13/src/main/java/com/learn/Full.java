package com.learn;

/**
 * 单例模式——懒汉式
 */
public class Full {
    private static Full instance = null;

    private Full() {

    }

    public static Full getInstance() {
        if (instance == null) {
            instance = new Full();
        }
        return instance;
    }

}
