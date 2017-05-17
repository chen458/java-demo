package com.csh.demo.effective.java.concurrent;

import java.awt.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author: shenghong.chen
 * Date: 2016/11/20
 * time: 下午8:24
 */
public class Restaurant {
    ExecutorService exec = Executors.newCachedThreadPool();
    Meal meal;
    Chef chef = new Chef(this);
    WaitPerson waitPerson = new WaitPerson(this);

    public Restaurant() {
        exec.execute(chef);
        exec.execute(waitPerson);
    }

    public static void main(String[] args) {
        new Restaurant();
    }
}

class Meal{
    private final int orderNum;

    public Meal(int orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "Meal " + orderNum;
    }
}

class Chef implements Runnable {
    private Restaurant restaurant;
    private int count;

    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void run() {
        try {
            while ( ! Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal != null) {
                        wait();
                    }
                }
                if ( ++ count == 10){
                    System.out.println("Out of food, closing");
                    restaurant.exec.shutdownNow();
                    return;
                }
                System.out.println("Order up !");
                synchronized (restaurant.waitPerson) {
                    Meal meal = new Meal(count);
                    restaurant.waitPerson.notifyAll();
                }
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (Exception e) {
            System.out.println("Chef interrupted");
        }
    }
}

class WaitPerson implements Runnable {
    private Restaurant r;

    public WaitPerson(Restaurant r) {
        this.r = r;
    }

    public void run() {
        try {
            while (! Thread.interrupted()) {
                synchronized (this) {
                    while (r.meal == null) {
                        wait();
                    }
                }
                System.out.println("waitperson  got " + r.meal);
                synchronized (r.chef) {
                    r.meal = null;
                    r.chef.notifyAll();
                }
            }
        } catch (Exception e) {
            System.out.println("Waiting interrupted");
        }
    }
}