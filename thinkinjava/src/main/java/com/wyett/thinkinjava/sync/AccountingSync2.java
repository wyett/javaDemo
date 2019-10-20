package com.wyett.thinkinjava.sync;
import java.util.concurrent.*;

/**
 * @author ：chelei
 * @date ：Created in 2019/6/10 18:11
 * @description：TODO
 * @modified By：
 * @version: $
 */

public class AccountingSync2 implements Runnable {
    static AccountingSync2 instance =
            new AccountingSync2();
    static int i = 0;
    @Override
    public void run() {
        //使用同步代码块对变量i进行同步操作，对象为instance
        synchronized (instance) {
            for(int j = 0; j< 1000000; j++){
                i++;
            }
        }
    }
    public static void main(String[] args)
        throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();t2.start();
        t1.join();t2.join();
        System.out.println(i);
    }
}
