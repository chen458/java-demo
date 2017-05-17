package com.csh.demo.effective.java;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/**
 * @author: shenghong.chen
 * Date: 2016/11/17
 * time: 下午11:24
 */
public class CountDownLatchTest {

    public static long time(Executor executor,
                            int concurrency,
                            final Runnable action) throws InterruptedException {
        final CountDownLatch ready = new CountDownLatch(concurrency);
        final CountDownLatch start = new CountDownLatch(1);
        final CountDownLatch done = new CountDownLatch(concurrency);
        for (int i = 0; i< concurrency; i ++ ) {
            executor.execute(new Runnable() {
                public void run() {
                    ready.countDown();
                    try {
                        start.await();
                        action.run();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        done.countDown();
                    }
                }
            });
        }
        ready.await();
        long startNanos = System.nanoTime();
        start.countDown();
        done.await();
        return System.nanoTime() - startNanos;
    }
}
