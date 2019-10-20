package com.wyett.thinkinjava.concurrency_ex;

import sun.security.provider.NativePRNG;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.concurrent.*;

import static com.wyett.util.Print.print;

/**
 * @author : chelei
 * @date : Created in 2019/7/12 16:02
 * @description: TODO
 * @modified By:
 * @version: $
 */

class LiftOff2 implements Runnable{
    private static int countDown = 10;
    private static int taskCount;
    private final int id = taskCount++;
    public LiftOff2() { }
    public LiftOff2(int countDown) { this.countDown = countDown; }
    public String status() {
        return "#" + id + "(" +
                (countDown > 0 ? countDown : "LiftOff2!") + "), ";
    }
    public void run() {
        while(countDown-- > 0) {
            print(status());
            Thread.yield();
        }
    }
}

class LiftOff2Runner implements Runnable {
    private BlockingQueue<LiftOff2> queue;
    public LiftOff2Runner(BlockingQueue<LiftOff2> queue) {
        this.queue = queue;
    }
    public void add(LiftOff2 io) {
        try {
            queue.put(io);
        } catch(InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void run() {
        try {
            while(!Thread.interrupted()) {
                LiftOff2 h = queue.take();
                h.run();
            }
        } catch(InterruptedException e) {
            print("waiting from take()");
        }
        print("Exiting LiftOff2Runner");
    }
}

//class AddElementToBlockingQueue<T> implements Runnable {
//    private BlockingQueue<T> rockets;
//    public AddElementToBlockingQueue(BlockingQueue<T> queue) {
//        this.rockets = queue;
//    }
//    public void run() {
//        try {
//            while(!Thread.interrupted()) {
//                rockets.put(T v);
//            }
//        } catch(InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}

class LiftOff2Producer implements Runnable {
    private LiftOff2Runner runner;
    public LiftOff2Producer(LiftOff2Runner runner) {
        this.runner = runner;
    }
    public void run() {
        try {
            for(int i = 0; i < 5; i++)
                runner.add(new LiftOff2(5));
        } catch(Exception e) {
            print("waking from put()");
        }
        print("Exiting LiftOff2Producer");
    }
}

class TestBlockingQueues {
    static void getkey() {
        try {
            new BufferedReader(
                    new InputStreamReader(System.in)).readLine();
        } catch(java.io.IOException e) {
            throw new RuntimeException(e);
        }
    }
    static void getkey(String message) {
        print(message);
        getkey();
    }
    static void
    test(String msg, BlockingQueue<LiftOff2> queue) {
        ExecutorService exec = Executors.newCachedThreadPool();
        print(msg);
        LiftOff2Runner runner = new LiftOff2Runner(queue);
        LiftOff2Producer producer = new LiftOff2Producer(runner);
        exec.execute(runner);
        exec.execute(producer);
        getkey("Press 'ENTER ' (" + msg + ")");
        exec.shutdownNow();
        print("Finished " + msg + " test");
    }
}

public class Ex28 {
    public static void main(String[] args) {
        TestBlockingQueues tbq = new TestBlockingQueues();
        tbq.test("LinkedBlockQueue",
                new LinkedBlockingDeque<LiftOff2>());
        tbq.test("ArrayBlockingQueue",
                new ArrayBlockingQueue<LiftOff2>(3));
        tbq.test("SynchronousQueue",
                new SynchronousQueue<LiftOff2>());
    }
}
