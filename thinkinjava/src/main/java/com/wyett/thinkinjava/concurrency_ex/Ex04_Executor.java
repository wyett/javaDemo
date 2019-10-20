package com.wyett.thinkinjava.concurrency_ex;
import java.util.concurrent.*;
/**
 * @author ：chelei
 * @date ：Created in 2019/6/4 14:44
 * @description：TODO
 * @modified By：
 * @version: $
 */

public class Ex04_Executor {
    public static void main(String[] args){
        ExecutorService exec =
                Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++)
            exec.execute(new Ex02_Fibonacci(i));
        Thread.yield();
        exec.shutdown();
        System.out.println("================");
        exec = Executors.newFixedThreadPool(3);
        for(int i = 0; i < 5; i++)
            exec.execute(new Ex02_Fibonacci(i));
        Thread.yield();
        exec.shutdown();
        System.out.println("================");
        exec = Executors.newSingleThreadExecutor();
        for(int i = 0; i < 5; i++)
            exec.execute(new Ex02_Fibonacci(i));
        Thread.yield();
        exec.shutdown();
    }
}
