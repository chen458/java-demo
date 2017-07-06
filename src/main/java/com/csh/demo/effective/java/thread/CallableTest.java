package com.csh.demo.effective.java.thread;

import java.util.concurrent.*;

/**
 * @author chenshenghong
 * @version 1.0
 * @created 2017/7/4
 * @time 上午10:19
 */
public class CallableTest {
    public static void main(String[] args) {

    }
    public void futureMethod (){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future future = executor.submit(new CallableDemo());
        executor.shutdown();
        try {
            System.out.println("Future 主线程执行其他任务开始!");
            TimeUnit.MILLISECONDS.sleep(2000);
            System.out.println("Future 主线程执行其他任务结束!");

            if (null != future.get()) {
                System.out.println("future.get() --> " + future.get());
            } else {
                System.out.println("future.get()未获取到结果");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Future 主线程 done ");
    }

    public void futureTaskMethod(){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        FutureTask task = new FutureTask<>(new CallableDemo());
        executor.shutdown();
        try {
            System.out.println("FutureTask 主线程执行其他任务开始!");
            TimeUnit.MILLISECONDS.sleep(2000);
            System.out.println("FutureTask 主线程执行其他任务结束!");

            if (null != task.get()) {
                System.out.println("futureTask.get() --> " + task.get());
            } else {
                System.out.println("futureTask.get()未获取到结果");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("FutureTask 主线程 done ");
    }
}


class CallableDemo implements Callable {
    private int sum;
    @Override
    public Object call() throws Exception {
        System.out.println("Callable 子线程开始计算!");
        TimeUnit.MILLISECONDS.sleep(1000);//休眠 10000 ms
        for (int i = 0; i< 5000; i++)
            sum += i;
        System.out.println("Callable 子线程开始结束!");
        return sum;
    }
}
