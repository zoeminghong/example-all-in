package com.zerostech.design.mode.charpter04.putong;

/**
 * Created on 2020-02-28.
 *
 * @author 迹_Jason
 */
public class HangzhouPizza implements Pizza{

    @Override
    public void prepare() {
        System.out.println("HangZhou prepare");
    }

    @Override
    public void bake() {
        System.out.println("HangZhou bake");
    }

    @Override
    public void cut() {
        System.out.println("HangZhou cut");
    }

    @Override
    public void box() {
        System.out.println("HangZhou box");
    }
}
