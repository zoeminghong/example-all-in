package com.charpter02;

/**
 * Created on 2019-10-25.
 *
 * @author 迹_Jason
 */
public interface Subject {
    void registObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
