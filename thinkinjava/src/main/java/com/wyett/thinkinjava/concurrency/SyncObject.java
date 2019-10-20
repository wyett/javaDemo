package com.wyett.thinkinjava.concurrency;
import static com.wyett.util.Print.*;

/**
 * @author : chelei
 * @date : Created in 2019/6/27 17:07
 * @description: TODO
 * @modified By:
 * @version: $
 */

class DualSynch {
    private Object syncObject = new Object();
    public synchronized void f() {
        for( int i = 0; i < 5; i++) {
            print("f()");
            Thread.yield();
        }
    }
    public void g() {
        synchronized(syncObject) {
            for(int i = 0; i < 5; i++) {
                print("g()");
                Thread.yield();
            }
        }
    }
}

public class SyncObject {
    public static void main(String[] args) {
        final DualSynch ds = new DualSynch();
        new Thread() {
            public void run() {
                ds.f();
            }
        }.start();
        print("============");
        ds.g();
    }
}
