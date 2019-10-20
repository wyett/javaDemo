package com.wyett.thinkinjava.concurrency_ex;
import java.util.*;
import java.util.concurrent.*;

class FibonacciSum2 {
    private static ExecutorService exec;
    private static int fib(int n){
        if(n < 2) return 1;
        return fib(n-2) + fib(n-1);
    }
    public static synchronized
    Future<Integer> runTask(final int n) {
        assert exec != null;
        return exec.submit(new Callable<Integer>(){
            public Integer call() {
                int sum = 0;
                for(int i = 0; i < n; i++)
                    sum += fib(i);
                return sum;
            }
        });
    }
    public static synchronized void init() {
        if(exec == null)
            exec = Executors.newCachedThreadPool();
    }
    public static synchronized void shutdown() {
        if(exec != null)
            exec.shutdown();
        exec = null;
    }
}

/**
 * @author ：chelei
 * @date ：Created in 2019/6/10 12:13
 * @description：TODO
 * @modified By：
 * @version: $
 */
public class Ex10_FibonacciSum2 {
    public static void main(String[] args) {
        ArrayList<Future<Integer>> results =
                new ArrayList<Future<Integer>>();
        FibonacciSum2.init();
        for(int i = 1; i < 5; i++)
            results.add(FibonacciSum2.runTask(i));
        Thread.yield();
        for(Future<Integer> fi : results) {
            try {
                System.out.println(fi.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
