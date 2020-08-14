package com.zerostech.design.mode.charpter06;

/**
 * Created on 2020-02-28.
 *
 * @author 迹_Jason
 */
public abstract class CaffeineBeverage {

    final void prepareRecipte() {
        brew();
        addCondiments();
        biolWater();
    }

    protected abstract void brew();

    protected abstract void addCondiments();

    private void biolWater() {
        System.out.println("biolWater");
    }

}
