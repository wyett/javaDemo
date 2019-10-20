package com.wyett.thinkinjava.concurrency;
import java.util.concurrent.*;

/**
 * @author ：chelei
 * @date ：Created in 2019/6/17 15:52
 * @description：TODO
 * @modified By：
 * @version: $
 */

public class SettingDefaultHandler {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(
                new MyUncaughtExceptionHandler());
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread());
    }
}
