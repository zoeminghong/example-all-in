package com.zerostech.design.mode.charpter04.putong;

/**
 * Created on 2020-02-28.
 *
 * @author 迹_Jason
 */
public class HangzhouStore {

    private PizzaFactory pizzaFactory;

    public HangzhouStore(PizzaFactory pizzaFactory) {
        this.pizzaFactory = pizzaFactory;
    }

    public Pizza orderPizza(String type){
        Pizza pizza=pizzaFactory.createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    public static void main(String[] args) {
        HangzhouStore store=new HangzhouStore(new PizzaFactory());
        store.orderPizza("Hangzhou");
    }
}
