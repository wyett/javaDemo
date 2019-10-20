package com.wyett.thinkinjava.concurrency_ex;
import java.util.concurrent.*;

/**
 * @author ：chelei
 * @date ：Created in 2019/6/4 14:23
 * @description：TODO
 * @modified By：
 * @version: $
 */

public class Ex3_Executor {
    public static void main(String[] args){
        System.out.println("newCachedThreadPool()");
        ExecutorService exec =
                Executors.newCachedThreadPool();
        for(int i = 0; i <5; i++)
            exec.execute(new Ex01_Runnable("dog", 5));
        Thread.yield();
        exec.shutdown();
        System.out.println("===============");
        System.out.println("newFixedThreadPool(2)");
        exec = Executors.newFixedThreadPool(2);
        for(int i = 0; i <5; i++)
            exec.execute(new Ex01_Runnable("cat", 5));
        Thread.yield();
        exec.shutdown();
        System.out.println("===============");
        System.out.println("newSingleThreadExecutor()");
        exec = Executors.newSingleThreadExecutor();
        for(int i = 0; i <5; i++)
            exec.execute(new Ex01_Runnable("pig", 5));
        Thread.yield();
        exec.shutdown();
    }
}
