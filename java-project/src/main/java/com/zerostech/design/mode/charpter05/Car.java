package com.zerostech.design.mode.charpter05;

/**
 * Created on 2020-02-19.
 *
 * @author 迹_Jason
 */
public class Car {

    private Framework framework;

    public Car(Framework framework) {
        this.framework = framework;
    }


    public static void main(String[] args) {
        Wheel wheel=new Wheel(10);
        Chassis chassis=new Chassis(wheel);
        Framework framework=new Framework(chassis);

        Car car= new Car(framework);
    }
}
