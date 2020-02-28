package com.charpter04.gongchangfangfa;


/**
 * Created on 2020-02-28.
 * <p>
 * 工厂方法
 *
 * @author 迹_Jason
 */
public class HangZhouStore extends StoreAbstract {
    public static void main(String[] args) {
        HangZhouStore store = new HangZhouStore();
        store.orderPizza();
    }

    @Override
    protected Pizza createPizza() {
        return new HangzhouPizza();
    }
}
