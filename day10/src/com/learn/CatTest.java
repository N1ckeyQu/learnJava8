package com.learn;

/**
 * 通常我们编写一个JavaBean，都会将属性的访问权限设置为private
 * 如果设为public，那么用户可以直接通过：对象名.属性名的方式来获取/修改该属性值
 * 此时能够限制用户的只有该属性的数据类型允许的范围（基本数据类型都是有范围的）
 * 以及对应的数据类型本身（假设该属性是String类型，那么用户不能修改成一个浮点数）
 * 但是在实际开发过程中，我们往往需要加上更多的限制，比如说API的调用者可能会输入一些不符合我们预期的情况
 * 此时我们需要对这个属性来进行封装，如何实现？可以将属性的访问修饰符改为private，只允许在该类内部直接操作该属性
 * 这样一来，我们在这个类外部就无法操作该属性。那我们如何修改/访问这个属性值？
 * 可以写该属性对应的get/set方法，将方法的访问修饰符设为public，我们可以在get/set方法中写入一些逻辑
 * 去矫正那些不符合我们预期的情况。而对于API的调用者，他不需要关心这些逻辑，他只需要能修改/访问即可
 * 因此封装了属性之后，既满足了API调用者的需求，也满足了API创建者的需求，双赢
 *
 * 从上述内容中不难看出，实现封装性的重要工具就是访问修饰符，在Java中一共有4种访问修饰符
 * 权限从小到大排列：private、缺省、protected、public
 *
 * 对于class，只能用public/default来修饰。public类可以在任意地方被访问，default类可以被同一个包内部的类访问
 */
public class CatTest {
    public static void main(String[] args) {
        Cat c = new Cat();
        c.name = "猫咪";
        c.age = 1;
        c.setLegs(6);
    }
}

class Cat {
    String name;
    protected int age;
    private int legs;

    public void setLegs(int l) {
        legs = l;
    }
}
