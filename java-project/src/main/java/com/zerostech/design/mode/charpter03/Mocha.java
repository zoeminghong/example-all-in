package com.zerostech.design.mode.charpter03;

/**
 * Created on 2019-11-03.
 *
 * @author 迹_Jason
 */

/**
 * 为什么 Macha 要继承  CondimentDecorator 而不是 Beverage
 */
public class Mocha extends CondimentDecorator {
    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        return 0.20 + beverage.cost();
    }
}
