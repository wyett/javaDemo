package com.wyett.thinkinjava.concurrency;
import java.util.*;
import java.util.concurrent.*;
import static com.wyett.util.Print.*;

/**
 * @author ：chelei
 * @date ：Created in 2019/6/5 17:36
 * @description：TODO
 * @modified By：
 * @version: $
 */

public class SimpleDaemon implements Runnable{
    public void run() {
        /**
         * description: TODO
         * @param  * @Param:
         * @return void
         */
        try{
            while(true){
                TimeUnit.MILLISECONDS.sleep(100);
                print(Thread.currentThread() + " " + this);
            }
        }catch(InterruptedException e) {
            print("sleep() interruptted");
        }
    }
    public static void main(String[] args) throws Exception{
        for(int i = 0; i < 10; i++){
            Thread daemon = new Thread(new SimpleDaemon());
            daemon.setDaemon(true);
            daemon.start();
        }
        print("All daemons started");
        TimeUnit.MILLISECONDS.sleep(175);
//        TimeUnit.MILLISECONDS.sleep(50);
    }
}
