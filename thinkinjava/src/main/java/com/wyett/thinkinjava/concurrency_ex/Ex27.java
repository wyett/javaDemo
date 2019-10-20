package com.wyett.thinkinjava.concurrency_ex;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.wyett.util.Print.print;

/**
 * @author : chelei
 * @date : Created in 2019/7/11 17:33
 * @description: TODO
 * @modified By:
 * @version: $
 */

class Meal3 {
    private int orderNum = 0;
    public Meal3(int orderNum) { this.orderNum = orderNum; }
    public String toString() { return "Meal " + orderNum; }
}

class WaitPerson3 implements Runnable{
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    private Restaurant3 restaurant;
    public WaitPerson3(Restaurant3 restaurant) {
        this.restaurant = restaurant;
    }
    public void run() {
        try {
            while(!Thread.interrupted()) {
                lock.lock();
                try {
                    while(restaurant.meal == null) {
                        condition.await();
                    }
                } finally {
                    lock.unlock();
                }
                print("wait person get meal " + restaurant.meal);
                restaurant.chef.lock.lock();
                try {
                    restaurant.meal = null;
                    restaurant.chef.condition.signalAll();
                } finally {
                    restaurant.chef.lock.unlock();
                }
            }
        } catch(InterruptedException e) {
            print("End of wait person");
        }
    }
}

class Chef3 implements  Runnable {
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    private Restaurant3 restaurant;
    private int count = 0;
    public Chef3(Restaurant3 restaurant) {
        this.restaurant = restaurant;
    }
    public void run() {
        try {
            while(!Thread.interrupted()) {
                lock.lock();
                try {
                    while(restaurant.meal != null) {
                        condition.await();
                    }
                } finally {
                    lock.unlock();
                }
                if(++count == 10) {
                    print("chef3 interrupted");
                    restaurant.exec.shutdownNow();
                }
                restaurant.waitPerson.lock.lock();
                try {
                    print("singal chef to make meal");
                    restaurant.meal = new Meal(count);
                    restaurant.waitPerson.condition.signalAll();
                } finally {
                    restaurant.waitPerson.lock.unlock();
                }
                TimeUnit.MILLISECONDS.sleep(200);
            }
        } catch(InterruptedException e) {
            print("End of chef");
        }
    }
}

class Restaurant3 {
    Meal meal;
    WaitPerson3 waitPerson = new WaitPerson3(this);
    Chef3 chef = new Chef3(this);
    ExecutorService exec = Executors.newCachedThreadPool();
    public Restaurant3() {
        exec.execute(waitPerson);
        exec.execute(chef);
    }
}


public class Ex27{
    public static void main(String[] args) throws Exception {
        new Restaurant3();
    }
}
