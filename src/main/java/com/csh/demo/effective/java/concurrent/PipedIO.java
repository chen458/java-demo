package com.csh.demo.effective.java.concurrent;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author: shenghong.chen
 * Date: 2016/11/20
 * time: 下午10:25
 */
public class PipedIO {
    public static void main(String[] args) throws IOException, InterruptedException {
        Sender sender = new Sender();
        Receiver receiver = new Receiver(sender);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(sender);
        exec.execute(receiver);
        TimeUnit.SECONDS.sleep(4);
        exec.shutdown();

        int[] temp = new int[5];
    }
}

class Sender implements Runnable {
    private Random rand = new Random(47);
    private PipedWriter out = new PipedWriter();

    public PipedWriter getOut() {
        return out;
    }

    public void setOut(PipedWriter out) {
        this.out = out;
    }

    public void run() {
        try {
            while (true) {
                for (char c = 'A'; c <= 'z'; c ++) {
                    out.write(c);
                    TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
                }
            }
        } catch (IOException ioe) {
            System.out.println(ioe + " Sender writer exception");
        } catch (InterruptedException ie) {
            System.out.println(ie + " Sender sleep interrupted");
        }
    }
}

class Receiver implements Runnable {
    private PipedReader in;

    public Receiver(Sender sender) throws IOException {
        in = new PipedReader(sender.getOut());
    }

    public void run() {
        try {
            while (true) {
                System.out.println("Read: " + (char)in.read());
            }
        } catch (IOException ioe) {
            System.out.println(ioe + " Receiver read exception");
        }
    }
}
