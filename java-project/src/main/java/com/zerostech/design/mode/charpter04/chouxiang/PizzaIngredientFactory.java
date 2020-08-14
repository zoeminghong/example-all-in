package com.zerostech.design.mode.charpter04.chouxiang;

/**
 * Created on 2019-11-03.
 *
 * @author 迹_Jason
 */
public interface PizzaIngredientFactory {
     Dough createDough();
     Sauce creatSauce();
     Cheese creatCheese();
}
