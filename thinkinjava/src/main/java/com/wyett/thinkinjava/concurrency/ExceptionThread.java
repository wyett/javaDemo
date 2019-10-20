package com.wyett.thinkinjava.concurrency;
import java.util.concurrent.*;

/**
 * @author ：chelei
 * @date ：Created in 2019/6/17 14:38
 * @description：TODO
 * @modified By：
 * @version: $
 */

public class ExceptionThread implements Runnable{
    public void run() {
        throw new RuntimeException();
    }
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread());
    }
}
