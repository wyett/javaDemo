package com.wyett.thinkinjava.concurrency;
import java.util.concurrent.*;

/**
 * @author ：chelei
 * @date ：Created in 2019/6/17 14:45
 * @description：TODO
 * @modified By：
 * @version: $
 */

public class NativeExceptionHandling {
    public static void main(String[] args) {
        try {
            ExecutorService exec =
                    Executors.newCachedThreadPool();
            exec.execute(new ExceptionThread());
        } catch (RuntimeException ue) {
            System.out.println("Exception has been handled");
        }
    }
}
