package com.wyett.thinkinjava.concurrency;
import java.util.concurrent.*;
/**
 * @author ：chelei
 * @date ：Created in 2019/6/4 13:50
 * @description：TODO
 * @modified By：
 * @version: $
 */

public class SingleThreadExecutor {
    public static void main(String[] args){
        ExecutorService exec =
                Executors.newSingleThreadExecutor();
        for(int i = 0; i < 5; i++)
            exec.execute(new LiftOff());
        exec.shutdown();
    }
}
