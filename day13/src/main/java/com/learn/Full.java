package com.learn;

import java.util.Objects;

/**
 * 单例模式——懒汉式
 */
public class Full {
    private static Full instance = null;

    private Full() {

    }

    public static Full getInstance() {
        if (Objects.isNull(instance)) {
            instance = new Full();
        }
        return instance;
    }

}
