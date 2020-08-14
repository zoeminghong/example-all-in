package com.zerostech.design.mode.charpter03;

/**
 * Created on 2019-11-03.
 *
 * @author 迹_Jason
 */
public class Espresso extends Beverage {

    public Espresso() {
        description="Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
