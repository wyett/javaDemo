package com.wyett.thinkinjava.concurrency;
import static com.wyett.util.Print.*;
import com.wyett.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author ：chelei
 * @date ：Created in 2019/6/5 18:11
 * @description：TODO
 * @modified By：
 * @version: $
 */

public class DaemonFromFactory implements Runnable{

    /**
     * create by:
     * description: TODO
     * create time: 2019/6/5 18:20
     *
     * @param * @Param: null
     * @return
     */
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                print(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            print("Interrupted");
        }
    }
    public static void main(String[] args)  throws Exception {
        ExecutorService exec =
                Executors.newCachedThreadPool(
                        new DaemonThreadFactory());
        for(int i = 0; i< 10; i++)
            exec.execute(new DaemonFromFactory());
        print("ALL daemos started");
        TimeUnit.MILLISECONDS.sleep(500);
    }
}
