package com.wyett.thinkinjava.concurrency;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.wyett.util.Print.print;


/**
 * @author : chelei
 * @date : Created in 2019/7/8 10:20
 * @description: TODO
 * @modified By:
 * @version: $
 */

class BlockedMutex {
    private Lock lock = new ReentrantLock();
    public BlockedMutex() {
        // Acquire it right away, to demonstrate interruption
        // of a task blocked on a ReentrantLock
        lock.lock();
        print("-----------------");
    }
    public void f() {
        try {
            // This will never be available to a second task
            lock.lockInterruptibly();
            print("lock accuired in f()");
        } catch(InterruptedException e) {
            print("Interrupted from lock acquisition in f()");
        }
    }
}

class Blocked2 implements Runnable {
    BlockedMutex blocked = new BlockedMutex();
    public void run() {
        print("Waiting for f() in BlockedMutex");
        blocked.f();
        print("Broken out of blocked call");
    }
}

public class Interrupting2 {
    public static void main(String[] args) throws Exception {
        Thread t = new Thread(new Blocked2());
        print("===========");
        t.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Issuing t.interrupt");
        t.interrupt();
    }
}
