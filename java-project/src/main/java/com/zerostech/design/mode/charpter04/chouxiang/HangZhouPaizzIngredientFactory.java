package com.zerostech.design.mode.charpter04.chouxiang;

/**
 * Created on 2020-02-28.
 *
 * @author 迹_Jason
 */
public class HangZhouPaizzIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThickCrusDough();
    }

    @Override
    public Sauce creatSauce() {
        return new PlumTomatoSauce();
    }

    @Override
    public Cheese creatCheese() {
        return new MozzarellaCheese();
    }
}
