package com.wyett.thinkinjava.concurrency_ex;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static com.wyett.util.Print.print;

/**
 * @author : chelei
 * @date : Created in 2019/7/9 19:07
 * @description: TODO
 * @modified By:
 * @version: $
 */

class Car {
    private boolean waxOn;
    public synchronized void waxed(){
        waxOn = true;
        notify();
    }
    public synchronized void buffed() {
        waxOn = false;
        notify();
    }
    public synchronized void waitForWaxing()
    throws InterruptedException{
        while(waxOn == false)
            wait();
    }
    public synchronized void waitForBuffing()
    throws InterruptedException {
        while(waxOn == true)
            wait();
    }

}

class WaxOn implements Runnable {
    private Car car;
    public WaxOn(Car car) { this.car = car; }
    public void run() {
        try {
            while(!Thread.interrupted()) {
                print("wax on!");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitForBuffing();
            }
        } catch(InterruptedException e) {
            print("Exiting via interrupted");
        }
        print("Ending of class WaxOn");
    }
}

class WaxOff implements Runnable {
    private Car car;
    public WaxOff(Car car) { this.car = car; }
    public void run() {
        try {
            while (!Thread.interrupted()) {
                print("wax off!");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
                car.waitForWaxing();
            }
        } catch (InterruptedException e) {
            print("Exiting via interrupted");
        }
        print("Ending of class WaxOff");
    }
}

public class Ex23 {
    public static void main(String[] args)  throws Exception {
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff(car));
        exec.execute(new WaxOn(car));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
