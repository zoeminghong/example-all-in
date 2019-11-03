package com.charpter03;

/**
 * Created on 2019-11-03.
 *
 * @author 迹_Jason
 */
public abstract class Beverage {
    String description ="Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
