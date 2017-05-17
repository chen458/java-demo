package com.csh.demo.effective.java.concurrent;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author: shenghong.chen
 * Date: 2016/11/21
 * time: 上午8:32
 */
public class ToastoMatic {
    public static void main(String[] args) throws InterruptedException {
        ToastQueue queue = new ToastQueue();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Toaster(queue));
        exec.execute(new Butterer(queue));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdown();
    }
}

class Toast {
    public enum Status {DRY, BUTTERED}
    private Status status = Status.DRY;
    private final int id;

    public Toast(int id) {
        this.id = id;
    }
    public void butter(){
        status = Status.BUTTERED;
    }

    public Status getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Toast " + id + " : " + status;
    }
}

class ToastQueue extends LinkedBlockingQueue<Toast>{}

class Toaster implements Runnable {
    private ToastQueue toastQueue;
    private int count = 0;
    private Random rand = new Random(47);

    public Toaster(ToastQueue toastQueue) {
        this.toastQueue = toastQueue;
    }

    public void run() {
        try {
            if ( ! Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(100 + rand.nextInt(500));
                Toast toast = new Toast(count++);
                System.out.println("生产: " + toast);
                toastQueue.put(toast);
            }
        } catch (Exception e) {
            System.out.println("Toaster interruptd ");
        }
        System.out.println("Toaster off");
    }
}

class Butterer implements Runnable {
    private ToastQueue queue;

    public Butterer(ToastQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            while ( ! Thread.interrupted()) {
                Toast toast = queue.take();
                toast.butter();
                System.out.println("抹黄油: " + toast);
            }
        } catch (Exception e) {
            System.out.println();
        }
    }
}