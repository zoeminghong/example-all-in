package com.zerostech.design.mode.charpter07;

/**
 * Created on 2020-02-28.
 *
 * @author 迹_Jason
 */
public class Singleton {

    private static volatile Singleton singleton;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public void doSomething(){
        System.out.println("doSomething .....");
    }

}
