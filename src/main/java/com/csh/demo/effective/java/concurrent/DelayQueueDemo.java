package com.csh.demo.effective.java.concurrent;

import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: shenghong.chen
 * Date: 2016/11/20
 * time: 下午3:12
 */
public class DelayQueueDemo {
    public static void main(String[] args) {
        Random random = new Random(47);
        ExecutorService exec = Executors.newCachedThreadPool();
        DelayQueue queue = new DelayQueue<DelayedTask>();
        for (int i = 0; i < 20; i ++) {
            queue.put(new DelayedTask(random.nextInt(2000)));
        }
        queue.add(new DelayedTask.EndSentinel(2000, exec));
        exec.execute(new DelayedTaskConsumer(queue));
        exec.shutdown();
    }
}
