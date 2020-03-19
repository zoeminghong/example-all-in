package com.zerostech.stock.broadcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created on 2020-03-19.
 *
 * @author 迹_Jason
 */
@SpringBootApplication
@EnableScheduling
public class BroadcastApplication {

    public static void main(String[] args) {
        SpringApplication.run(BroadcastApplication.class, args);
    }
}
