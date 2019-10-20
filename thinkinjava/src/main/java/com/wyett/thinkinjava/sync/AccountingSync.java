package com.wyett.thinkinjava.sync;
import java.util.concurrent.*;

/**
 * @author ：chelei
 * @date ：Created in 2019/6/10 15:24
 * @description：TODO
 * @modified By：
 * @version: $
 */

public class AccountingSync implements Runnable{
    // critical resource
    static int i = 0;
    // synchronized modify instance func
    public synchronized void increase() {
        i++;
    }
    @Override
    public void run() {
        for(int j = 0; j<1000000; j++) {
            increase();
        }
    }
    public static void main(String[] args)
        throws InterruptedException {
        AccountingSync instance = new AccountingSync();
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
