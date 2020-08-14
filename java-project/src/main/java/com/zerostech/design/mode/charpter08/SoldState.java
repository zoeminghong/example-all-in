package com.zerostech.design.mode.charpter08;

/**
 * Created on 2020-02-28.
 *
 * @author 迹_Jason
 */
public class SoldState implements State {

    private GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("SoldState insertQuarter");
    }

    @Override
    public void ejectQuarter() {
        gumballMachine.setState(gumballMachine.getSoldState());
        System.out.println("SoldState ejectQuarter");
    }

    @Override
    public void turnCrank() {
        gumballMachine.setState(gumballMachine.getSoldOutState());
        System.out.println("SoldState turnCrank");
    }

    @Override
    public void dispense() {
        System.out.println("SoldState dispense");
    }
}
