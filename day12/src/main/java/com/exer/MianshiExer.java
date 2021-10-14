package com.exer;

/**
 * 阴险的面试题
 */
public class MianshiExer {
    public static void main(String[] args) {
        //三元运算符后面的两个选择，类型应当保持一致。下面这种不一致的类型，会进行类型的提升，int会提升为double
        Object o1 = true ? new Integer(1) : new Double(2.0);
        System.out.println(o1);


        /**
         * Integer内部定义了一个叫做IntegerCache的类，IntegerCache中定义了Integer[]
         * 这个数组保存了-128~127的整数，如下所示，如果我们使用自动装箱的方式给Integer赋值
         * 并且这个值刚好在缓存的整数范围内，无需new Integer，而是直接赋值，类似于String的常量池
         * 如果超出这个范围，就相当于需要new Integer了
         */
        Integer i1 = 1;
        Integer i2 = 1;
        //true
        System.out.println(i1 == i2);

        Integer i3 = 128;
        Integer i4 = 128;
        //false
        System.out.println(i3 == i4);
    }
}
