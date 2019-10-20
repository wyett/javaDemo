package com.wyett.thinkinjava.concurrency;

/**
 * @author : chelei
 * @date : Created in 2019/7/3 11:20
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class YieldDemo {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            for(int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "-------" + i);
                if (i % 20 == 0) {
                    Thread.yield();
                }
            }
        };
        new Thread(runnable, "老板").start();
        new Thread(runnable, "小蜜").start();
    }
}
