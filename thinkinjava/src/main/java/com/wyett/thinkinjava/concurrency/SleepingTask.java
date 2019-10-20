package com.wyett.thinkinjava.concurrency;
import java.util.concurrent.*;
/**
 * @author ：chelei
 * @date ：Created in 2019/6/4 18:40
 * @description：TODO
 * @modified By：
 * @version: $
 */

public class SleepingTask extends LiftOff{
    public void run() {
        try{
            while(countDown-- >0){
                System.out.print(status());
                TimeUnit.MILLISECONDS.sleep(100);
            }
        }catch(InterruptedException e){
            System.err.println("Interrupted");
        }
    }
    public static void main(String[] args){
        ExecutorService exec =
                Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++)
            exec.execute(new SleepingTask());
        exec.shutdown();
    }
}
