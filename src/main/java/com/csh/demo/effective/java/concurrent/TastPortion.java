package com.csh.demo.effective.java.concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author: shenghong.chen
 * Date: 2016/11/20
 * time: 下午12:58
 */
public class TastPortion implements Runnable {
    private static int counter = 0;
    private final int id = counter ++;
    private static Random rand = new Random(47);
    private final CountDownLatch latch;

    public TastPortion(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {
        try {
            doWork();
            latch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void doWork() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(rand.nextInt(2000));
        System.out.println(this + " completed !");
    }

    @Override
    public String toString() {
        return String.format("%1$-3d", id);
    }
}
