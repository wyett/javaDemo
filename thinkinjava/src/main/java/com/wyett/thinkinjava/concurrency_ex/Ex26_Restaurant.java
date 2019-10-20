package com.wyett.thinkinjava.concurrency_ex;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static com.wyett.util.Print.print;

/**
 * @author : chelei
 * @date : Created in 2019/7/11 11:13
 * @description: TODO
 * @modified By:
 * @version: $
 */

class Meal2 {
    private int orderNum = 0;
    public Meal2(int orderNum) { this.orderNum = orderNum; }
    @Override
    public String toString() { return "Meal2 " + orderNum; }
}

class DiningTable2 {
//    enum Table { EMPTY, FULL };
    private boolean tableState;
    public DiningTable2(boolean tableState) {
        this.tableState = tableState;
    }
    @Override
    public String toString() {
        return "dining table is " + tableState;
    }
}

class WaitPerson2 implements Runnable{
    private Ex26_Restaurant restaurant;
    private boolean tableState;
    public WaitPerson2(Ex26_Restaurant rest) {
        this.restaurant = rest;
    }
    @Override
    public void run() {
        try {
            while(!Thread.interrupted()){
                synchronized (this) {
                    while(restaurant.meal == null ||
                            restaurant.diningTable == null) {
                        wait();
                    }
                }
                print("waitperson get " + restaurant.meal);
                synchronized (restaurant.chef) {
                    restaurant.meal = null;
                    restaurant.chef.notify();
                }
                if(restaurant.diningTable == null) {
                    restaurant.diningTable = new DiningTable2(true);
                }
                print("busBoy: " + restaurant.busBoy);
                synchronized (restaurant.busBoy) {
                    restaurant.diningTable = new DiningTable2(true);
                    restaurant.busBoy.notify();
                }
            }
        } catch(InterruptedException e) {
            print("end of wait person");
        }
    }
}

class Chef2 implements Runnable{
    private Ex26_Restaurant restaurant;
    private int count = 0;
    public Chef2(Ex26_Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    @Override
    public void run() {
        try {
            while(!Thread.interrupted()){
                synchronized (this) {
                    while(restaurant.meal != null) {
                        wait();
                    }
                }
                if(++count == 10) {
                    print("chef was interrupted");
                    restaurant.exec.shutdownNow();
                }
                print("give meal to waitPerson");
                synchronized (restaurant.waitPerson) {
                    restaurant.meal = new Meal2(count);
                    restaurant.waitPerson.notify();
                }
                TimeUnit.MILLISECONDS.sleep(200);
            }
        } catch(InterruptedException e) {
            print("end of chef");
        }
    }
}

class BusBoy2 implements Runnable{
    private Ex26_Restaurant restaurant;
    public BusBoy2(Ex26_Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                synchronized (this) {
                    while(restaurant.diningTable == null) {
                        wait();
                    }
                }
                print("tell waitPerson table is empty");
                synchronized (restaurant.waitPerson) {
                    restaurant.diningTable = null;
                    restaurant.waitPerson.notify();
                }
            }
        } catch(InterruptedException e) {
            print("end of busBoy");
        }
    }
}

public class Ex26_Restaurant {
    Meal2 meal;
    DiningTable2 diningTable = new DiningTable2(false);
    WaitPerson2 waitPerson = new WaitPerson2(this);
    Chef2 chef = new Chef2(this);
    BusBoy2 busBoy = new BusBoy2(this);
    ExecutorService exec = Executors.newCachedThreadPool();
    public Ex26_Restaurant() {
        exec.execute(waitPerson);
        exec.execute(chef);
        exec.execute(busBoy);
    }
    public static void main(String[] args) throws Exception {
        new Ex26_Restaurant();
    }
}
