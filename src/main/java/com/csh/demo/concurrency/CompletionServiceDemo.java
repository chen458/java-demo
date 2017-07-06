package com.csh.demo.concurrency;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author: shenghong.chen
 * Date: 2017/7/7
 * time: 上午12:17
 */
public class CompletionServiceDemo {
    private volatile static int time = 20;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        ExecutorCompletionService<String> completionService = new ExecutorCompletionService<String>(executor);
        for (int i = 10; i > 0; i --) {
            completionService.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    TimeUnit.SECONDS.sleep(time);
                    return "sleep = " + time -- ;
                }
            });
        }
        try {
            for (int i = 10; i > 0; i --) {
                Future<String> future = completionService.take();
                System.out.println(future.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
