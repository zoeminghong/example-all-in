package com.zerostech.design.mode.charpter08;

/**
 * Created on 2020-02-28.
 *
 * @author 迹_Jason
 */
public class SoldOutState implements State {

    private GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        gumballMachine.setState(gumballMachine.getSoldState());
        System.out.println("SoldOutState insertQuarter");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("SoldOutState ejectQuarter");
    }

    @Override
    public void turnCrank() {
        gumballMachine.setState(gumballMachine.getSoldOutState());
        System.out.println("SoldOutState turnCrank");
    }

    @Override
    public void dispense() {
        System.out.println("SoldOutState dispense");
    }
}
