package com.zerostech.design.mode.charpter06;

/**
 * Created on 2020-02-28.
 *
 * @author 迹_Jason
 */
public class Coffee extends CaffeineBeverage {
    public static void main(String[] args) {
        Coffee coffee = new Coffee();
        coffee.prepareRecipte();
    }

    @Override
    protected void brew() {
        System.out.println("brew");
    }

    @Override
    protected void addCondiments() {
        System.out.println("addCondiments");
    }
}
