package com.wyett.thinkinjava.sync;

/**
 * @author ：chelei
 * @date ：Created in 2019/6/10 21:10
 * @description：TODO
 * @modified By：
 * @version: $
 */

public class AccountingSync3 implements Runnable {
    static AccountingSync3 instance = new AccountingSync3();
    static int i = 0;
    static int j = 0;
    @Override
    public void run() {
        for(int j = 0; j < 1000000; j++){
            // 当前实例对象锁
            synchronized(this){
                i++;
                //可重入性
                increase();
            }
        }
    }
    public synchronized void increase() {
        i++;
    }
    public static void main(String[] args)
        throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
