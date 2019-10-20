package com.wyett.thinkinjava.sync;

import java.util.concurrent.TimeUnit;

/**
 * @author ：chelei
 * @date ：Created in 2019/6/11 16:54
 * @description：TODO
 * @modified By：
 * @version: $
 */

public class InterruptedThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {
            public void run() {
                while(true){
                    System.out.println("未被中断");
                }
            }
        };
        t1.start();
        TimeUnit.SECONDS.sleep(2);
        t1.interrupt();
    }
}
