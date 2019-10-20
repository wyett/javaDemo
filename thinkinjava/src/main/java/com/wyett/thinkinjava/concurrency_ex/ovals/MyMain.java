package com.wyett.thinkinjava.concurrency_ex.ovals;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static com.wyett.util.Print.print;

/**
 * @author : chelei
 * @date : Created in 2019/7/10 16:31
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class MyMain {
    public static void main(String[] args) throws Exception {
        if(args.length < 2) {
            print("Usage: java MyMain " +
                "<producer delay time> <consumer delay time>");
            System.exit(0);
        }
        int producerTime = Integer.parseInt(args[0]);
        int consumerTime = Integer.parseInt(args[1]);
        CommonQueue<Item> myQueue = new CommonQueue<Item>(100);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Producer<Item>(myQueue, producerTime));
        exec.execute(new Consumer<Item>(myQueue, consumerTime));
        TimeUnit.MILLISECONDS.sleep(2);
        exec.shutdownNow();
    }
}
