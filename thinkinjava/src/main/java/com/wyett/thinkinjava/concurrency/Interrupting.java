package com.wyett.thinkinjava.concurrency;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.*;
import java.io.*;
import static com.wyett.util.Print.*;

/**
 * @author : chelei
 * @date : Created in 2019/7/3 12:15
 * @description: Interrupting a blocked thread
 * @modified By:
 * @version: $
 */

class SleepBlocked implements Runnable {
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch(InterruptedException e) {
            print("InterruptedException");
        }
        print("Exiting SleepBlocked.run()");
    }
}

class IOBlocked implements Runnable {
    private InputStream in;
    public IOBlocked(InputStream is) { in = is; }
    public void run() {
        try {
            print("Waiting for read()");
            in.read();
        } catch(IOException e) {
            if (Thread.currentThread().isInterrupted()) {
                print("Interrupted from blocked I/O");
            } else {
                throw new RuntimeException(e);
            }
        }
        print("Exiting IOBlocked.run()");
    }
}

class SynchronizedBlocked implements Runnable {
    public synchronized void f() {
        while(true) {
            Thread.yield();
        }
    }
    public SynchronizedBlocked() {
        new Thread() {
            public void run() {
                f();
            }
        }.start();
    }
    public void run() {
        print("Trying to call f()");
        f();
        print("Exiting SynchronizedBlocked.run()");
    }
}

public class Interrupting {
    private static ExecutorService exec =
            Executors.newCachedThreadPool();
    static void test(Runnable r) throws InterruptedException {
        Future<?> f = exec.submit(r);
        System.out.println("==========");
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("----------");
        print("Interrupting " + r.getClass().getName());
        f.cancel(true);
        print("Interrupt send to " + r.getClass().getName());
    }
    public static void main(String[] args) throws Exception {
        test(new SleepingTask());
        test(new IOBlocked(System.in));
        test(new SynchronizedBlocked());
        TimeUnit.SECONDS.sleep(3);
        print("Aborting with System.exit(0)");
        System.exit(0);
    }
}
