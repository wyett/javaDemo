package com.wyett.thinkinjava.sync;

import java.util.concurrent.TimeUnit;

/**
 * @author ：chelei
 * @date ：Created in 2019/6/11 17:04
 * @description：TODO
 * @modified By：
 * @version: $
 */

public class InterruptedThread2 {
    public static void main(String[] args)
        throws InterruptedException {
        Thread t = new Thread() {
            public void run() {
                while(true){
                    if(this.isInterrupted()) {
                        System.out.println("被打断");
                        break;
                    }
                }
                System.out.println("跳出循环");
            }
        };
        t.start();
        TimeUnit.SECONDS.sleep(2);
        t.interrupt();

    }
}
