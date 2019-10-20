package com.wyett.thinkinjava.concurrency_ex;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static com.wyett.util.Print.print;

/**
 * @author : chelei
 * @date : Created in 2019/7/9 10:25
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class BusyWait_E22 {
    private static volatile boolean flag = false;
    private static int spins = 0;
    public static void main(String[] args) throws Exception {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                for(;;) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (InterruptedException e) { }
                    flag = true;
                }
            }
        };
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                for(;;) {
                    while (!flag && !Thread.currentThread().isInterrupted())
                        spins++;
                    print("wait " + spins + " times");
                    spins = 0;
                    flag = false;
                    if(Thread.interrupted())
                        return;
                }
            }
        };
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(r1);
        exec.execute(r2);
        TimeUnit.SECONDS.sleep(10);
        exec.shutdownNow();
    }
}
