package com.zerostech.design.mode.charpter04.gongchangfangfa;

/**
 * Created on 2020-02-28.
 *
 * @author 迹_Jason
 */
public abstract class StoreAbstract {

    public void orderPizza(){
        createPizza().createPizza();
        System.out.println("杭州披萨");
    }

    protected abstract Pizza createPizza();
}
