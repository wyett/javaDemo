package com.wyett.thinkinjava.concurrency_ex;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static com.wyett.util.Print.print;

/**
 * @author : chelei
 * @date : Created in 2019/7/5 16:26
 * @description: TODO
 * @modified By:
 * @version: $
 */

class ANotRunnable {
    private static int id = 0;
    private final int tid = id++;
    public void waitLong() throws InterruptedException{
        TimeUnit.SECONDS.sleep(10);
        print("normally call ANoRunnable.f(" + tid + ")");
    }
}

class BRunnable implements Runnable{
    ANotRunnable anr = new ANotRunnable();
    public void run(){
        while(true) {
            try {
                anr.waitLong();
            } catch(InterruptedException e) {
//                print("Interrupt BRunnable.run()");
                print(e.toString());
            } finally {
                System.exit(0);
            }
        }
    }
}

public class Ex18 {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++)
            exec.execute(new BRunnable());
        TimeUnit.MILLISECONDS.sleep(500);
//        Thread.yield();
        exec.shutdownNow();
//        exec.shutdown();
        if(!exec.isShutdown())
            exec.shutdown();
    }
}
