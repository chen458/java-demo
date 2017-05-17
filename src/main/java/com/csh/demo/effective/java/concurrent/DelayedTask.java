package com.csh.demo.effective.java.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * @author: shenghong.chen
 * Date: 2016/11/20
 * time: 下午2:52
 */
public class DelayedTask implements Runnable, Delayed {
    private static int counter = 0;
    private final int id = counter ++;
    private final int delta;
    private final long triger;
    protected static List<DelayedTask> sequence =
            new ArrayList<DelayedTask>();

    public DelayedTask(int seconds) {
        delta = seconds;
        triger = System.nanoTime() + NANOSECONDS.convert(delta, MILLISECONDS);
    }

    public long getDelay(TimeUnit unit) {
        return unit.convert(triger - System.nanoTime(), NANOSECONDS);
    }

    public int compareTo(Delayed arg) {
        DelayedTask task = (DelayedTask)arg;
        if (triger < task.triger)
            return -1;
        if (triger > task.triger)
            return 1;
        return 0;
    }

    public void run() {
        System.out.println(this + "");
    }

    @Override
    public String toString() {
        return String.format("[%1$-4d]", delta) + " Task" + id;
    }

    public String summary(){
        return "(" + id + ":" + delta + ")";
    }

    public static class EndSentinel extends DelayedTask {
        private ExecutorService exec;

        public EndSentinel(int delay, ExecutorService service) {
            super(delay);
            this.exec = service;
        }

        @Override
        public void run() {
            for (DelayedTask task : sequence) {
                System.out.print(task.summary() + "");
            }
            System.out.println(this + " calling shutdownNow()");
            exec.shutdown();
        }
    }
}
