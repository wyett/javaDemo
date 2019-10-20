package com.wyett.thinkinjava.concurrency;
import java.sql.Time;
import java.util.concurrent.*;
import static com.wyett.util.Print.*;
/**
 * @author ：chelei
 * @date ：Created in 2019/6/5 19:40
 * @description：TODO
 * @modified By：
 * @version: $
 */

class ADaemon implements Runnable{
    public void run() {
        try{
            print("Starting ADaemon");
            TimeUnit.SECONDS.sleep(1);
        }catch(InterruptedException e) {
            print("Exiting via InterruptedException");
        }finally{
            print("This should always run?");
        }
    }
}

public class DaemonsDontRunFinally {
    public static void main(String[] args)
            throws Exception{
        Thread t = new Thread(new ADaemon());
        t.setDaemon(true);
        t.start();
        TimeUnit.MILLISECONDS.sleep(100);
    }
}
