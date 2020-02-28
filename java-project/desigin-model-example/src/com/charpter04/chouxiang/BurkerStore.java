package com.charpter04.chouxiang;

/**
 * Created on 2020-02-28.
 *
 * @author 迹_Jason
 */
public class BurkerStore implements Store{

    private PizzaIngredientFactory factory;

    public BurkerStore(PizzaIngredientFactory factory) {
        this.factory = factory;
    }

    @Override
    public void cook() {
        Cheese cheese=factory.creatCheese();
        Dough dough=factory.createDough();
        Sauce sauce=factory.creatSauce();
        cheese.doSomething();
        dough.doSomething();
        sauce.doSomething();
    }


    public static void main(String[] args) {

        BurkerStore store=new BurkerStore(new HangZhouPaizzIngredientFactory());
        store.cook();
    }
}
