package com.wyett.thinkinjava.concurrency;
import java.util.concurrent.*;
/**
 * @author ：chelei
 * @date ：Created in 2019/6/4 12:18
 * @description：TODO
 * @modified By：
 * @version: $
 */

public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++)
            exec.execute(new LiftOff());
        exec.shutdown();
    }
}
