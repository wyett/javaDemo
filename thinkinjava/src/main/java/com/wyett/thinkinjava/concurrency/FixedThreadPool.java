package com.wyett.thinkinjava.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ：chelei
 * @date ：Created in 2019/6/4 13:37
 * @description：TODO
 * @modified By：
 * @version: $
 */

public class FixedThreadPool {
    public static void main(String[] args) {
        ExecutorService exec =
                Executors.newFixedThreadPool(5);
        for(int i = 0; i < 5; i++)
            exec.execute(new LiftOff());
        exec.shutdown();
    }
}
