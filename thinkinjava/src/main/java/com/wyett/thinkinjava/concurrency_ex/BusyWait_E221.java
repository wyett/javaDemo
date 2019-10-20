package com.wyett.thinkinjava.concurrency_ex;

import java.sql.Time;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

import static com.wyett.util.Print.print;

/**
 * @author : chelei
 * @date : Created in 2019/7/9 11:29
 * @description: TODO
 * @modified By:
 * @version: $
 */
public class BusyWait_E221 {
    private static volatile boolean flag;
    public static void main(String[] args) throws Exception {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                for (;;) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(100);
                        synchronized (this) { notify(); }
                    } catch (InterruptedException e) {
                        return;
                    }
                    flag = true;
                }
            }
        };
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                for (;;) {
                    try {
                        synchronized (r1) { r1.wait(); }
                    } catch (InterruptedException e) {
                        return;
                    }
                    print("r2.wait()");
                }
            }
        };
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(r1);
        exec.execute(r2);
        TimeUnit.SECONDS.sleep(2);
        exec.shutdownNow();
    }
}
