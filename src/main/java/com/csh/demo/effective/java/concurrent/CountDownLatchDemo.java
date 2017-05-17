package com.csh.demo.effective.java.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: shenghong.chen
 * Date: 2016/11/20
 * time: 下午1:24
 */
public class CountDownLatchDemo {
    static final int SIZE = 100;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(SIZE);
        for (int i =0; i < 10; i ++ ){
            executor.execute(new WaitingTask(latch));
        }
        for (int i =0; i < SIZE; i ++ ){
            executor.execute(new TastPortion(latch));
        }
        System.out.println("结束");
        executor.shutdown();
    }
}
