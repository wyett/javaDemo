package com.wyett.thinkinjava.concurrency_ex.ovals;

import java.util.concurrent.TimeUnit;

/**
 * @author : chelei
 * @date : Created in 2019/7/10 16:30
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class Producer<T> implements Runnable {
    private static int delay;
    private CommonQueue<T> myQueue;
    public Producer(CommonQueue<T> myQueue, int delayTime) {
        this.myQueue = myQueue;
        delay = delayTime;
    }
    public void run() {
        for(;;) {
            try {
                System.out.println(myQueue.get());
                TimeUnit.MILLISECONDS.sleep(delay);
            } catch(InterruptedException e) {
                return;
            }
        }
    }
}
