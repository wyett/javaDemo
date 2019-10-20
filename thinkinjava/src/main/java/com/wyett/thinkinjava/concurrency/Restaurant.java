package com.wyett.thinkinjava.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static com.wyett.util.Print.print;
import static com.wyett.util.Print.printnb;

/**
 * @author : chelei
 * @date : Created in 2019/7/10 12:00
 * @description: TODO
 * @modified By:
 * @version: $
 */
class Meal {
    private static int orderNum = 0;
    public Meal(int orderNum) { this.orderNum = orderNum; }
    public String toString() { return "Meal " + orderNum; }
}

class WaitPerson implements Runnable {
    private Restaurant restaurant;
    public WaitPerson(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    public void run() {
        try {
            while(!Thread.interrupted()) {
                synchronized (this) {
                    // if no meal are ready, waitPerson wait()
                    while (restaurant.meal == null) {
                        wait();
                    }
                }
                print("waitPerson got " + restaurant.meal);
                // get meal and notify chef
                synchronized (restaurant.chef) {
                    restaurant.meal = null;
                    restaurant.chef.notifyAll();
                }
            }
        } catch(InterruptedException e) {
            print("waitPerson interrupted");
        }
    }
}

class Chef implements Runnable {
    private Restaurant restaurant;
    // count for mark meal num
    private int count = 0;
    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    public void run() {
        try {
            while(!Thread.interrupted()) {
                // wait for meal is null
                synchronized (this) {
                    while (restaurant.meal != null)
                        wait();
                }
                // if chef has product 10 meal, end today's work
                if (++count == 10) {
                    print("out of while with Interrupted");
                    restaurant.exec.shutdownNow();
                }
                printnb("order up!");
                // if meal is ok, notify waitPerson
                synchronized (restaurant.waitPerson) {
                    restaurant.meal = new Meal(count);
                    restaurant.waitPerson.notifyAll();
                }
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch(InterruptedException e) {
            print("chef interrupted");
        }
    }
}


public class Restaurant {
    Meal meal;
    WaitPerson waitPerson = new WaitPerson(this);
    Chef chef = new Chef(this);
    ExecutorService exec = Executors.newCachedThreadPool();
    public Restaurant() {
        exec.execute(chef);
        exec.execute(waitPerson);
    }
    public static void main(String[] args) throws Exception {
        new Restaurant();
    }
}




