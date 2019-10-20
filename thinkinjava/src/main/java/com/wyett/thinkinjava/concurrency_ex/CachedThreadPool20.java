package com.wyett.thinkinjava.concurrency_ex;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static com.wyett.util.Print.print;

/**
 * @author : chelei
 * @date : Created in 2019/7/5 15:16
 * @description: TODO
 * @modified By:
 * @version: $
 */

class LiftOff implements Runnable {
    private int countDown = 10;
    private static int count = 0;
    private final int id = count++;
    public LiftOff() {};
    public LiftOff(int count) { this.count = count; }
    public String toString(){
        return "#" + id + "("
                + (countDown > 0 ? countDown : "LiffOff!") +"), ";

    }
    public void run() {
        while(--countDown > 0) {
//            print("LiftOff run()");
            if(Thread.currentThread().isInterrupted()){
                System.out.println("Interrupted: #" + id);
                return;
            }
            print(this);
            Thread.yield();
        }
    }
}

public class CachedThreadPool20 {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
//        Thread.yield();
//        exec.shutdownNow();
        Thread.yield();
        exec.shutdown();
//        if(!exec.awaitTermination(100, TimeUnit.MILLISECONDS))
//            print("waiting for thread finished");
    }
}
