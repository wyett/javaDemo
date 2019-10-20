package com.wyett.thinkinjava.sync;

import java.util.concurrent.TimeUnit;

/**
 * @author ：chelei
 * @date ：Created in 2019/6/10 21:20
 * @description：TODO
 * @modified By：
 * @version: $
 */

public class InterruputSleepThread3 {
    public static void main(String[] args)
        throws InterruptedException {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                //通过异常退出run循环
                try{
                    while(true) {
                        //阻塞状态，异常捕获处理
                        TimeUnit.SECONDS.sleep(2);
                    }
                }catch(InterruptedException e){
                    System.out.println("Interruputed When Sleep");
                    boolean interrupt = this.isInterrupted();
                    //中断状态被复位
                    System.out.println("interrupt:" +interrupt);
                }
            }
        };
        t1.start();
        TimeUnit.SECONDS.sleep(2);
        //中断处于阻塞状态的线程
        t1.interrupt();
    }
}
