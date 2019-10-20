package com.wyett.thinkinjava.concurrency_ex;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static com.wyett.util.Print.print;

/**
 * @author : chelei
 * @date : Created in 2019/7/8 20:15
 * @description: TODO
 * @modified By:
 * @version: $
 */

class ARunnable implements Runnable {
    public void run(){
        print("ARunnable call wait()");
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                print("InterruptedException ARunnable");
            }
        }
        print("End of ARunnable");
    }
}

class CRunnable implements Runnable {
    Runnable otherTask;
    public CRunnable(Runnable otherTask) {
        this.otherTask = otherTask;
    }
    public void run() {
        print("CRunnable call notifyAll()");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch(InterruptedException e) {
            print("InterruptedException CRunnable");
        }
        synchronized (otherTask) { otherTask.notifyAll(); }
    }
}
public class Ex21 {
    public static void main(String[] args) throws Exception {
        Runnable ra = new ARunnable(),
                rc = new CRunnable(ra);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(ra);
        exec.execute(rc);
        Thread.yield();
        exec.shutdown();
    }
}
