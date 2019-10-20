package com.wyett.thinkinjava.concurrency_ex;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static com.wyett.util.Print.print;

/**
 * @author : chelei
 * @date : Created in 2019/7/4 17:36
 * @description: TODO
 * @modified By:
 * @version: $
 */

class Count19 {
    private int count = 0;
    private Random rand = new Random();
    public synchronized int increment() {
        int temp = count;
        if(rand.nextBoolean())
            Thread.yield();
        return (count = ++temp);
    }
    public synchronized int value() { return count; }
}

class Entrance implements Runnable {
    private static Count19 count = new Count19();
    private static List<Entrance> entrances =
            new ArrayList<Entrance>();
    private int number;
    private final int id;
    private volatile static boolean canceled = false;
    public static void cancel() { canceled = true; }
    public Entrance(int id) {
        this.id = id;
        entrances.add(this);
    }
    public void run(){
        while(!canceled){
            synchronized(this) {
                ++number;
            }
        }
        print(this + " total: " + count.increment());
        try{
            TimeUnit.MILLISECONDS.sleep(100);
        } catch(InterruptedException e) {
            print("sleep interrupted");
        }
    }
//    public void run() {
//        for(;;) {
//            synchronized(this) { ++number; }
//            print(this + " Total: " + count.increment());
//            try {
//                TimeUnit.MILLISECONDS.sleep(100);
//            } catch(InterruptedException e) {
//                print("Stopping " + this);
//                return;
//            }
//        }
//}
    public synchronized int getValue(){ return number; }
    public String toString(){
        return "Entrance: " + id + ":" + getValue();
    }
    public static int getTotalCount(){
        return count.value();
    }
    public static int sumEntrance(){
        int sum = 0;
        for(Entrance entrance: entrances)
            sum += entrance.getValue();
        return sum;
    }
}

public class OrnamentalGarden19 {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
//        static void test(Runnable r) throws InterruptedException {
//            Future<?> f = exec.submit(new Entrance(i));
//            TimeUnit.SECONDS.sleep(3);
//            f.cancel(true);
//        }
        Future<?> f = null;
        for(int i = 0; i < 5; i++) {
            f = exec.submit(new Entrance(i));
//            exec.execute(new Entrance(i));
        }
        TimeUnit.SECONDS.sleep(3);
        f.cancel(true);
        Entrance.cancel();
        exec.shutdown();
//        exec.shutdownNow();
        if(!exec.awaitTermination(300, TimeUnit.MILLISECONDS))
            print("Some task was not ternamial");
        print("Total: " + Entrance.getTotalCount());
        print("Sum of Entrance: " + Entrance.sumEntrance());
    }
}
