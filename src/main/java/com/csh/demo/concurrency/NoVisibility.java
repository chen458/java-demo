package com.csh.demo.concurrency;

/**
 * 可见性
 *
 * @author: shenghong.chen
 * Date: 2017/6/27
 * time: 下午11:29
 */
public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (! ready)
                Thread.yield();
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        // 下面两句可能"重排序"
        number = 42;
        ready = true;
    }
}
