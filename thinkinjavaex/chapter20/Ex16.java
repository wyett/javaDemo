package thinkinjava.concurrency_ex;

import java.util.concurrent.locks.*;
import static com.wyett.util.Print.*;

/**
 * @author : chelei
 * @date : Created in 2019/7/2 14:30
 * @description: TODO
 * @modified By:
 * @version: $
 */

class SingleLock{
    private Lock lock = new ReentrantLock();
    public void f() {
        lock.lock();
        try {
            for(int i = 0; i < 5; i++) {
                print("f()");
                Thread.yield();
            }
        } finally {
                lock.unlock();
        }
    }
    public void g() {
        lock.lock();
        try {
            for(int i = 0; i < 5; i++) {
                print("g()");
                Thread.yield();
            }
        } finally {
            lock.unlock();
        }
    }
    public void h() {
        lock.lock();
        try {
            for(int i = 0; i < 5; i++) {
                print("h()");
                Thread.yield();
            }
        } finally {
            lock.unlock();
        }
    }
}

class TripleLock {
//    private Object lockObjectF = new Object();
//    private Object lockObjectH = new Object();
//    private Object lockObjectG = new Object();
    private Lock lockF = new ReentrantLock();
    private Lock lockG = new ReentrantLock();
    private Lock lockH = new ReentrantLock();
    public void f(){
        lockF.lock();
        try {
            for(int i = 0; i < 5; i++) {
                print("f(TripleLock)");
                Thread.yield();
            }
        } finally {
            lockF.unlock();
        }
    }
    public void g() {
        lockG.lock();
        try {
            for(int i = 0; i < 5; i++) {
                print("g(TripleLock)");
                Thread.yield();
            }
        } finally {
            lockG.unlock();
        }
    }
    public void h() {
        lockH.lock();
        try {
            for(int i = 0; i < 5; i++) {
                print("h(TripleLock)");
                Thread.yield();
            }
        } finally {
            lockH.unlock();
        }
    }
}

public class Ex16 {
    public static void main(String[] args) throws Exception {
        SingleLock singleLock = new SingleLock();
        TripleLock tripleLock = new TripleLock();
        Thread t1 = new Thread(){
            public void run(){
                singleLock.f();
            }
        };
        t1.start();
        Thread t2 = new Thread(){
            public void run() {
                singleLock.g();
            }
        };
        t2.start();
        singleLock.h();
        t1.join();
        t2.join();
        print("TripleLock begin...");
        new Thread(){
            public void run() {
                tripleLock.f();
            }
        }.start();
        new Thread(){
            public void run() {
                tripleLock.g();
            }
        }.start();
        tripleLock.h();
    }
}
