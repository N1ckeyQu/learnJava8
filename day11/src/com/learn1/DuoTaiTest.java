package com.learn1;

import java.util.ArrayList;
import java.util.List;

/**
 * 多态：可以理解为一个事物的多种形态
 * 具体体现为：父类的引用指向子类的对象（子类的对象赋给父类的引用）
 *
 * 多态性的使用前提：
 * 1、类的继承关系、接口的实现关系
 * 2、方法的重写
 *    比如list.add()方法，点进去看到是List接口的add方法，但实际调用的是ArrayList的add方法
 *    这说明在编译期，如果使用多态性，只能调用父类/接口中声明的方法。在运行期实际调用的是子类重写父类的方法/接口实现类的方法
 *
 * 3、对象的多态性，只适用于方法，不适用于属性
 */
public class DuoTaiTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
    }
}
