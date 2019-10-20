package com.wyett.thinkinjava.sync;
import java.util.concurrent.*;

/**
 * @author ：chelei
 * @date ：Created in 2019/6/10 16:23
 * @description：TODO
 * @modified By：
 * @version: $
 */

public class AccountingSyncBad implements Runnable {
    static int i = 0;
    public synchronized void increase() {
        i++;
    }
    @Override
    public void run() {
        for(int j = 0; j< 1000000; j++) {
            increase();
        }
    }
    public static void main(String[] args)
        throws InterruptedException {
        Thread t1 = new Thread(new AccountingSyncBad());
        Thread t2 = new Thread(new AccountingSyncBad());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
