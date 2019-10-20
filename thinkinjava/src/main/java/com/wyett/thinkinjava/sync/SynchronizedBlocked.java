package com.wyett.thinkinjava.sync;

import java.util.concurrent.TimeUnit;

/**
 * @author ：chelei
 * @date ：Created in 2019/6/11 18:24
 * @description：TODO
 * @modified By：
 * @version: $
 */

public class SynchronizedBlocked implements Runnable{
    public synchronized  void f() {
        System.out.println("Trying to call f()");
        while(true)
            Thread.yield();
    }
    public SynchronizedBlocked() {
        new Thread() {
            public void run() {
                f();
            }
        }.start();
    }
    public void run() {
        while(true) {
            if(Thread.interrupted()) {
                System.out.println("中断线程");
                break;
            } else {
                f();
            }
        }
    }
    public static void main(String[] args)
        throws InterruptedException {
        SynchronizedBlocked sync = new SynchronizedBlocked();
        Thread t = new Thread(sync);
        t.start();
        TimeUnit.SECONDS.sleep(1);
        t.interrupt();
    }
}
