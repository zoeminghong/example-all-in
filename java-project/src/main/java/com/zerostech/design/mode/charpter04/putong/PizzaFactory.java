package com.zerostech.design.mode.charpter04.putong;

/**
 * Created on 2020-02-28.
 *
 * @author 迹_Jason
 */
public class PizzaFactory {

    public Pizza createPizza(String type) {
        if (type.equalsIgnoreCase("HangZhou")) {
            return new HangzhouPizza();
        } else {
            return null;
        }
    }
}
