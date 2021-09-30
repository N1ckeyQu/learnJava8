package com.learn;

/**
 * 通过递归方式，计算1~100的和
 */
public class RecursionTest {
    public static void main(String[] args) {
        System.out.println(getSum(100));
        System.out.println(getX(10));
        System.out.println(getFn(10));
    }

    public static int getSum(int i) {
        //递归和死循环最大的区别在于我们需要有一个明确的递归结束条件
        //当100减小到1时，直接return 1，不再继续向下进行递归
        if (i == 1) {
            return 1;
        }
        //形参代表最大值，这里倒着计算
        return i + getSum(--i);
    }

    public static int getX(int i) {
        if (i == 1) {
            return 1;
        }
        return i * getX(i - 1);
    }

    //已知f(1)=1, f(2)=4, f(n+2)=2*f(n+1)+f(n), 求f(10)的值
    public static int getFn(int i) {
        if (i == 1) {
            return 1;
        } else if (i == 2) {
            return 4;
        }
        return 2 * getFn(i - 1) + getFn(i - 2);
    }
}
