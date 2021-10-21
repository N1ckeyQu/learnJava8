package com.exer;

import java.util.Collection;

public class Test2 {

}

interface Playable {
    void play();
}

interface Bounceable {
    void play();
}

interface Rollable extends Playable, Bounceable {
    Ball ball = new Ball("PingPang");
}

class Ball implements Rollable {

    private String name;

    public String getName() {
        return name;
    }

    public Ball(String name) {
        this.name = name;
    }

    public void play() {
        //常量无法修改
//        ball = new Ball("FootBall");
        System.out.println(ball.getName());
    }
}
