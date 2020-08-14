package com.zerostech.design.mode.charpter07;

/**
 * Created on 2020-02-28.
 *
 * @author 迹_Jason
 */
public class SingletonTest {

    public static void main(String[] args) {
//        Singleton singleton=new Singleton();
        Singleton singleton = Singleton.getInstance();
        singleton.doSomething();
    }
}
