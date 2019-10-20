package com.wyett.thinkinjava.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import static com.wyett.util.Print.print;

/**
 * @author : chelei
 * @date : Created in 2019/7/3 16:46
 * @description: TODO
 * @modified By:
 * @version: $
 */
class Hello implements Runnable {
    private String name;
    public Hello(String name){
        this.name = name;
    }
    public void run(){
        while(true) {
            try {
                System.out.println("Hello, " + name);
                TimeUnit.MILLISECONDS.sleep(50);
            } catch(InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class SynchronizedHello implements Runnable {
    private synchronized void h() {
        System.out.println("synchronizedHello.h()");
        while(true)
            Thread.yield();
    }
    public SynchronizedHello(){
        System.out.println("SynchronizedHello.constructor()");
        new Thread() {
            public void run(){
                h();
            }
        }.start();
    }
    public void run(){
        System.out.println("start SynchronizedHello.run()");
        h();
    }
}

public class ExecutorDemo {
    private static ExecutorService exec =
            Executors.newCachedThreadPool();
    public static void main(String[] args) throws Exception {
//        Future<?> f = exec.submit(new Hello("wyett"));
        Future<?> f = exec.submit(new SynchronizedHello());
        TimeUnit.MILLISECONDS.sleep(100);
        f.cancel(true);
        print("Interrupt send to " + Thread.currentThread().getName());
        System.exit(0);
    }
}
