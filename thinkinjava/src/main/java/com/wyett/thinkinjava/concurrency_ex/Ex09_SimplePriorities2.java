package com.wyett.thinkinjava.concurrency_ex;
import java.util.concurrent.*;
/**
 * @author ：chelei
 * @date ：Created in 2019/6/6 11:49
 * @description：TODO
 * @modified By：
 * @version: $
 */

class SimplePriorities2 implements Runnable{
    private int countDown = 5;
    private volatile double d;
    public String toString() {
        return Thread.currentThread() + ": " + countDown;
    }
    public void run() {
        for(;;) {
            for(int i = 1; i < 100000; i++) {
                d += (Math.PI + Math.E) / (double)i;
                if(i % 1000 == 0)
                    Thread.yield();
            }
            System.out.println(this);
            if(--countDown == 0) return;
        }
    }
}

class PriorityThreadFactory implements ThreadFactory {
    private final int priority;
    PriorityThreadFactory(int priority) {
        this.priority = priority;
    }
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setPriority(priority);
        return t;
    }
}

public class Ex09_SimplePriorities2 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool(
                new PriorityThreadFactory(Thread.MIN_PRIORITY));
        for(int i = 0; i < 5; i++)
            exec.execute(new SimplePriorities2());
        Thread.yield();
        exec.shutdown();
        exec = Executors.newCachedThreadPool(
                new PriorityThreadFactory(Thread.MAX_PRIORITY));
        exec.execute(new SimplePriorities2());
        Thread.yield();
        exec.shutdown();
    }
}
