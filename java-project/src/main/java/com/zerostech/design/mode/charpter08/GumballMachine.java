package com.zerostech.design.mode.charpter08;

/**
 * Created on 2020-02-28.
 *
 * @author 迹_Jason
 */
public class GumballMachine {

    private State soldOutState;
    private State state;
    private State soldState;

    public GumballMachine() {
        this.soldOutState = new SoldOutState(this);
        this.soldState = new SoldState(this);
        state = this.soldOutState;
    }

    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine();
        gumballMachine.insertQuarter();
        gumballMachine.ejectQuarter();
        gumballMachine.turnCrank();
    }

    void insertQuarter() {
        state.insertQuarter();
    }

    void ejectQuarter() {
        state.ejectQuarter();
    }

    void turnCrank() {
        state.turnCrank();
    }

    void dispense() {
        state.turnCrank();
    }

    public State getState() {
        return state;
    }

    public GumballMachine setState(State state) {
        this.state = state;
        return this;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getSoldState() {
        return soldState;
    }
}
