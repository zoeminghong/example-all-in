package com.charpter01;

/**
 * Created on 2019-10-25.
 *
 * @author 迹_Jason
 */
public abstract class Duck {

    private Flyable flyable;
    private Quackable quackable;

    void swim() {
        System.out.println("游泳");
    }

    abstract void display();

    void performQuack() {
        quackable.quack();
    }

    void performFly() {
        flyable.fly();
    }

    public Flyable getFlyable() {
        return flyable;
    }

    public void setFlyable(Flyable flyable) {
        this.flyable = flyable;
    }

    public Quackable getQuackable() {
        return quackable;
    }

    public void setQuackable(Quackable quackable) {
        this.quackable = quackable;
    }
}
