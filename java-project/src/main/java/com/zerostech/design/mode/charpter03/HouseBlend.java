package com.zerostech.design.mode.charpter03;

/**
 * Created on 2019-11-03.
 *
 * @author 迹_Jason
 */
public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
