package com.zerostech.design.mode.charpter09;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created on 2020-04-01.
 *
 * @author 迹_Jason
 */
public class SemaphoreExample {

    // 临界区就是在同一时刻只能有一个任务访问的代码区
    public static void main(String[] args) {

        // 线程池

        ExecutorService exec = Executors.newCachedThreadPool();

        // 只能5个线程同时访问

        final Semaphore semp = new Semaphore(1, true);

        // 模拟20个客户端访问

        for (int index = 0; index < 20; index++) {

            final int NO = index;

            Runnable run = new Runnable() {

                public void run() {

                    try {

                        // 获取许可

                        semp.acquire();

                        System.out.println("Accessing: " + NO);

                        Thread.sleep((long) (Math.random() * 10000));

                        // 访问完后，释放
                        semp.release();

                        System.out.println("-----------------" + semp.availablePermits());

                    } catch (InterruptedException e) {

                        e.printStackTrace();

                    }

                }

            };

            exec.execute(run);

        }

        // 退出线程池

        exec.shutdown();

    }
}
