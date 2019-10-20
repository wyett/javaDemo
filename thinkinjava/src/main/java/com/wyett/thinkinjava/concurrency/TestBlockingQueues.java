package com.wyett.thinkinjava.concurrency;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;

import static com.wyett.util.Print.print;

/**
 * @author : chelei
 * @date : Created in 2019/7/11 19:03
 * @description: TODO
 * @modified By:
 * @version: $
 */
class LiftOffRunner implements Runnable {
    private BlockingQueue<LiftOff> rockets;
    public LiftOffRunner(BlockingQueue<LiftOff> queue) {
        rockets = queue;
    }
    public void add(LiftOff io) {
        try {
            // BlockingQueue.put()将io写入rockets，等待空间
            rockets.put(io);
        } catch(InterruptedException e) {
            print("Interrupted during put()");
        }
    }
    public void run() {
        try {
            while(!Thread.interrupted()) {
                // BlockingQueue.take()，移除队列头
                LiftOff rocket = rockets.take();
                rocket.run();
            }
        } catch(InterruptedException e) {
            print("Waking from take()");
        }
        print("Exiting LiftOffRunner");
    }
}

public class TestBlockingQueues {
    static void getkey() {
        try {
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch(java.io.IOException e) {
            throw new RuntimeException(e);
        }
    }
    static void getkey(String message) {
        print(message);
        getkey();
    }
    static void test(String msg, BlockingQueue<LiftOff> queue) {
        print(msg);
        LiftOffRunner runner = new LiftOffRunner(queue);
        Thread t = new Thread(runner);
        t.start();
        for(int i = 0; i < 5; i++)
            runner.add(new LiftOff(5));
        getkey("Press 'Enter' (" + msg + ")");
        t.interrupt();
        print("Finished " + msg + " test");
    }
    public static void main(String[] args) {
        test("LinkedBlockingQueue",
                new LinkedBlockingDeque<LiftOff>());
        test("ArrayBlockingQueue",
                new ArrayBlockingQueue<LiftOff>(3));
        test("SynchronousQueue",
                new SynchronousQueue<LiftOff>());
    }
}
