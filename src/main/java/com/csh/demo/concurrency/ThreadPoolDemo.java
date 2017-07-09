package com.csh.demo.concurrency;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

/**
 * ThreadPoolExecutor 是可扩展的,可以改写
 *      beforeExecute : 线程执行开始前执行
 *      afterExecute : 线程执行结束后执行,无论是正常结束还是异常结束
 *      terminated : 线程池完成关闭操作时调用
 *
 *  ThreadPoolDemo 增加了日志和计时等功能的线程池
 *
 * @author chenshenghong
 * @version 1.0
 * @created 2017/7/9
 * @time 下午5:28
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        for (int i = 0; i< 10; i++) {
            final TimingThreadPool threadPool = new TimingThreadPool(
                    2, //corePoolSize
                    2, //maximumPoolSize
                    0L, //keepAliveTime
                    TimeUnit.MILLISECONDS, //时间单位
                    new LinkedBlockingQueue<Runnable>(3) //工作队列
            );

            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        int time = new Random().nextInt(100);
                        TimeUnit.MILLISECONDS.sleep(time);
                        System.out.println(Thread.currentThread().getName() + " ---- " + time);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    static class TimingThreadPool extends ThreadPoolExecutor {
        private final ThreadLocal<Long> startTime = new ThreadLocal<Long>();
        private final Logger logger = Logger.getLogger("TimingThreadPool");
        private final AtomicLong numTasks = new AtomicLong();
        private final AtomicLong totalTime = new AtomicLong();

        public TimingThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        }

        @Override
        protected void beforeExecute(Thread t, Runnable r) {
            super.beforeExecute(t, r);
            logger.fine(String.format("Thread %s: start %s", t, r));
            System.out.println(String.format("Thread %s: start %s", t, r));
            startTime.set(System.nanoTime());
        }

        @Override
        protected void afterExecute(Runnable r, Throwable t) {
            try {
                long endTime = System.nanoTime();
                long taskTime = endTime - startTime.get();
                numTasks.incrementAndGet();
                totalTime.addAndGet(taskTime);
                logger.fine(String.format("Thread %s: end %s, time=%dns", t, r, taskTime));
                System.out.println(String.format("Thread %s: end %s, time=%dns", t, r, taskTime));
            } finally {
                super.afterExecute(r, t);
            }
        }

        @Override
        protected void terminated() {
            try {
                logger.fine(String.format("Terminated : avg time=%dns", totalTime.get() / numTasks.get()));
                System.out.println(String.format("Terminated : avg time=%dns", totalTime.get() / numTasks.get()));
            } finally {
                super.terminated();
            }
        }
    }

}
