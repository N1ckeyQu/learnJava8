package com.learn;

import org.junit.jupiter.api.Test;

/**
 * Java提供了8种基本数据类型的包装类，使得基本数据类型的变量具有类的特征
 */
public class WrapperTest {

    /**
     * 基本数据类型转换成包装类
     */
    @Test
    public void test1() {
        int i = 1;
        Integer integer = new Integer(i);
        Integer integer1 = Integer.valueOf(i);

        Float f = 12.3f;
        System.out.println(f);

        Integer in = Integer.valueOf("123");
        System.out.println(in);
    }


}
