package com.wyett.thinkinjava.sync;
import java.util.concurrent.*;

/**
 * @author ：chelei
 * @date ：Created in 2019/6/10 17:59
 * @description：TODO
 * @modified By：
 * @version: $
 */

public class AccountingSyncClass
implements Runnable{
    static int i = 0;
    public static synchronized void increase() {
        i++;
    }
    public synchronized void increase4Obj() {
        i++;
    }
    @Override
    public void run() {
        for(int j = 0; j < 1000000; j++) {
            increase();
        }
    }
    public static void main(String[] args)
        throws InterruptedException {
        Thread t1 = new Thread(new AccountingSyncClass());
        Thread t2 = new Thread(new AccountingSyncClass());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);

    }
}
