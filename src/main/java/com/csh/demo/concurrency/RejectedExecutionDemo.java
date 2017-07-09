package com.csh.demo.concurrency;

import java.util.concurrent.*;

/**
 * 饱和策略
 * ThreadPoolExecutor 的饱和策略通过调用 setRejectedExecutionHandler 来修改。
 * RejectedExecutionHandler 的实现:
 *  AbortPolicy:终止策略,默认策略。当新提交的任务无法保存到队列中等待执行时,抛出 RejectedExecutionExcetion。
 *  CallerRunsPolicy:调用者运行策略。该策略不抛弃任务,也不抛出异常,而是将某些任务回退到调用者(主线程),从而降低新任务的流量。
 *  DiscardPolicy:抛弃策略,抛弃任务
 *  DiscardOldPolicy:抛弃最旧任务策略,抛弃下一个将别执行的任务,然后尝试重新提交新任务。抛弃最旧策略最好不要和优先级队列一起使用,否则会抛弃优先级最高的任务。
 * @author chenshenghong
 * @version 1.0
 * @created 2017/7/9
 * @time 下午3:59
 */
public class RejectedExecutionDemo {

    public static void main(String[] args) {
        System.out.println("------ AbortPolicy -----");
        test(new ThreadPoolExecutor.AbortPolicy());

        System.out.println("------ DiscardPolicy -----");
        test(new ThreadPoolExecutor.DiscardPolicy());

        System.out.println("------ DiscardOldestPolicy -----");
        test(new ThreadPoolExecutor.DiscardOldestPolicy());

        System.out.println("------ CallerRunsPolicy -----");
        test(new ThreadPoolExecutor.CallerRunsPolicy());


    }



    public static void test(RejectedExecutionHandler handler){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2, //corePoolSize
                2, //maximumPoolSize
                0L, //keepAliveTime
                TimeUnit.MILLISECONDS, //时间单位
                new LinkedBlockingQueue<Runnable>(3) //工作队列
        );

        //设置饱和策略
        executor.setRejectedExecutionHandler(handler);
        for (int i =0 ; i < 10; i++) {
            try {
                executor.execute(new ThreadDemo(i));
            } catch (RejectedExecutionException e) {
                System.out.println(i +" --- 线程 : " + Thread.currentThread().getName() + " RejectedExecutionException");
            }
        }

    }


    static class ThreadDemo implements Runnable {
        private int num;

        public ThreadDemo(int num) {
            this.num = num;
        }

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(num +" --- 线程 : " + Thread.currentThread().getName());
        }
    }

    /**
     * 使用 Semaphore 控制任务提交速率
     */
    static class BoundedExecutor {
        private final Executor executor;
        private final Semaphore semaphore;

        public BoundedExecutor(Executor executor, Semaphore semaphore) {
            this.executor = executor;
            this.semaphore = semaphore;
        }

        public void submitTask(final Runnable command) throws InterruptedException {
            semaphore.acquire();
            try {
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            command.run();
                        } finally {
                            semaphore.release();
                        }
                    }
                });
            } catch (RejectedExecutionException e) {
                semaphore.release();
            }
        }
    }
}
