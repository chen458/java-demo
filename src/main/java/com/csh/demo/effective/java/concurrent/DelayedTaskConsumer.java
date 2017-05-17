package com.csh.demo.effective.java.concurrent;

import java.util.List;
import java.util.concurrent.DelayQueue;

/**
 * @author: shenghong.chen
 * Date: 2016/11/20
 * time: 下午3:09
 */
public class DelayedTaskConsumer implements Runnable {
    private DelayQueue<DelayedTask> list;

    public DelayedTaskConsumer(DelayQueue<DelayedTask> list) {
        this.list = list;
    }

    public void run() {
        try {
            while ( !Thread.interrupted()) {
                list.take().run();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" Finished DelayedTaskConsumer");
    }
}
