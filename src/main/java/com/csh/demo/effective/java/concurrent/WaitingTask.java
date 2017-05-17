package com.csh.demo.effective.java.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @author: shenghong.chen
 * Date: 2016/11/20
 * time: 下午1:16
 */
public class WaitingTask implements Runnable {
    private static int counter = 0;
    private final int id = counter ++;
    private final CountDownLatch latch;

    public WaitingTask(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {
        try {
            latch.await();
            System.out.println("Latch barrier 通过 :" + this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return String.format("WaitingTask %1$-3d", id);
    }
}
