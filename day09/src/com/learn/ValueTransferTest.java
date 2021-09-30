package com.learn;

/**
 * 值传递的机制
 * 如果是基本数据类型，传递给形参的是对应的数据，相当于copy了一份数据进行操作，不会对源数据产生影响
 * 如果是引用数据类型，传递给形参的是引用地址，操作的是堆空间中同一个对象
 *
 * 所以说Java中其实不存在引用传递，只有值传递，只是根据传输的数据类型不同，传递给形参的内容也不同
 */
public class ValueTransferTest {

    public static void main(String[] args) {
        ValueTransferTest test = new ValueTransferTest();
        test.first();
    }

    public void first() {
        int i = 5;
        Value v = new Value();
        v.i = 25;
        second(v, i);
        System.out.println(v.i);
    }

    public void second(Value v, int i) {
        i = 0;
        v.i = 20;
        Value val = new Value();
        v = val;
        System.out.println(v.i + "\t" + i);
    }
}

class Value{
    int i = 15;
}