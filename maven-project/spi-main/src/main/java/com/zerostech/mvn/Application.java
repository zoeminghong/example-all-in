package com.zerostech.mvn;

import com.sun.tools.javac.util.ServiceLoader;

import java.util.Iterator;

/**
 * Created on 2020-04-10.
 *
 * @author 迹_Jason
 */
public class Application {

    public static void main(String[] args) {
        ServiceLoader<SPIDemo> spiDemos = ServiceLoader.load(SPIDemo.class);

        Iterator<SPIDemo> s = spiDemos.iterator();

        while (s.hasNext()){
            s.next().execute();
        }
    }
}
