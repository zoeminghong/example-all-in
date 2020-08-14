package com.zerostech.design.mode.charpter01;

/**
 * Created on 2019-10-25.
 *
 * @author 迹_Jason
 */
public class MallarDuck extends Duck {


    public MallarDuck() {
        setFlyable(new FlyWithWings());
        setQuackable(new Quck());
    }

    @Override
    void display() {
        System.out.println("呱呱");
    }
}
