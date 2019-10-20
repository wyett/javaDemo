package com.wyett.thinkinjava.concurrency_ex;
import java.sql.Time;
import java.util.concurrent.*;
import static com.wyett.util.Print.*;
/**
 * @author ：chelei
 * @date ：Created in 2019/6/6 10:26
 * @description：TODO
 * @modified By：
 * @version: $
 */
class Ex07_Daemon implements Runnable {
    private Thread[] t = new Thread[20];
    public void run() {
        for(int i = 0; i < t.length; i++){
            t[i] = new Thread(new DaemonSpawn());
            t[i].start();
            printnb("DaemonSpawm " + i + " started, ");
        }
        for(int i = 0; i < t.length; i ++)
            printnb("t[" + i + "].isDaemon() = "  +
                t[i].isDaemon() + ", ");
        while(true)
            Thread.yield();
    }
}

class DaemonSpawn implements Runnable {
    public void run() {
        while(true)
            Thread.yield();
    }
}

public class Ex07_Daemons {
    public static void main(String[] args) throws Exception {
        Thread d = new Thread(new Ex07_Daemon());
        d.setDaemon(true);
        d.start();
        printnb("t.isDaemon() = " + d.isDaemon() + ", ");
        TimeUnit.MILLISECONDS.sleep(100);
    }
}
