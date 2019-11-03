package com.charpter02;

/**
 * Created on 2019-10-25.
 *
 * @author 迹_Jason
 */
public class CurrentConditionDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;

    public CurrentConditionDisplay(Subject weatherData) {
        weatherData.registObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current conditions:" + temperature + "F degrees and" + humidity + "% humidity");
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }
}
