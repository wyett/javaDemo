package thinkinjava.concurrency_ex;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static com.wyett.util.Print.print;

/**
 * @author : chelei
 * @date : Created in 2019/7/10 18:54
 * @description: TODO
 * @modified By:
 * @version: $
 */

class Meal {
    private int orderNum;
    public Meal(int orderNum) { this.orderNum = orderNum; }
    public String toString() { return "Meal " + orderNum; }
}

class WaitPerson implements Runnable {
    private Ex25_Restaurant restaurant;
    public WaitPerson(Ex25_Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    public void run() {
        try {
            while(!Thread.interrupted()) {
                synchronized (this) {
                    while(restaurant.meal == null)
                        wait();
                }
                print("get meal from chef");
                synchronized (restaurant.chef) {
                    restaurant.meal = null;
                    restaurant.chef.notify();
                }
            }
        } catch(InterruptedException e) {
//            return;
            print("Exit from waitPerson.run");
        }
    }
}

class Chef implements Runnable {
    private Ex25_Restaurant restaurant;
    private int count = 0;
    public Chef(Ex25_Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    public void run() {
        try{
            while(!Thread.interrupted()) {
                synchronized (this) {
                    while(restaurant.meal != null)
                        wait();
                }
                if(++count ==10){
                    print("out of chef by interrupted");
                    restaurant.exec.shutdownNow();
                    return;
                }
                print("give waitPerson meal");
                synchronized (restaurant.waitPerson) {
                    restaurant.meal = new Meal(count);
                    restaurant.waitPerson.notify();
                }
                TimeUnit.MILLISECONDS.sleep(200);
            }
        } catch(InterruptedException e) {
//            return;
            print("Exit from chef by Interrupted");
        }
    }
}

public class Ex25_Restaurant {
    Meal meal;
    WaitPerson waitPerson = new WaitPerson(this);
    Chef chef = new Chef(this);
    ExecutorService exec = Executors.newCachedThreadPool();
    public Ex25_Restaurant(){
        exec.execute(waitPerson);
        exec.execute(chef);
    }
    public static void main(String[] args) throws Exception {
        new Ex25_Restaurant();
    }
}
