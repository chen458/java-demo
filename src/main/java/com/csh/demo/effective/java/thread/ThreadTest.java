package com.csh.demo.effective.java.thread;

import java.util.concurrent.*;

/**
 * @author: shenghong.chen
 * Date: 2017/3/26
 * time: 下午4:17
 */
public class ThreadTest{
    public static void main(String[] args) {
        new ThreadDemo().start();
        new Thread(new RunableDemo()).start();
        Executors.newCachedThreadPool().submit(new CallableDemo1());
        Executors.newCachedThreadPool().execute(new RunableDemo());


    }
}

class ThreadDemo extends Thread {

    @Override
    public void run() {
        System.out.println("Tread 实现");
    }
}

class RunableDemo implements Runnable {

    @Override
    public void run() {
        System.out.println("Runable 实现");
    }
}

class CallableDemo1 implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("Callable 实现");
        return "Callable 实现";
    }
}