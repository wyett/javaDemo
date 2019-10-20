package com.wyett.thinkinjava.concurrency;
import java.util.concurrent.*;
import static com.wyett.util.Print.*;

/**
 * @author ：chelei
 * @date ：Created in 2019/6/5 19:05
 * @description：TODO
 * @modified By：
 * @version: $
 */

class Daemon implements Runnable {
    private Thread[] t = new Thread[10];
    public void run() {
        for(int i = 0; i< t.length; i++){
            t[i] = new Thread(new DaemonFromFactory());
            t[i].start();
            printnb("DaemonSpam " + i + " start. ");
        }
        for(int i = 0; i < t.length; i++)
            printnb("t[" + i + "].isDaemon() = " +
                t[i].isDaemon() + ", ");
        while(true)
            Thread.yield();
    }
}

class DaemonSpawn implements  Runnable {
    public void run() {
        while(true)
            Thread.yield();
    }
}

public class Daemons {
    public static void main(String[] args) throws Exception {
        Thread d = new Thread(new Daemon());
        d.setDaemon(true);
        d.start();
        printnb("d.isDaemon() = " + d.isDaemon() + ", ");
        TimeUnit.SECONDS.sleep(1);
    }
}
