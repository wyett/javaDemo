package com.wyett.thinkinjava.concurrency;
import javax.net.ssl.CertPathTrustManagerParameters;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

/**
 * @author ：chelei
 * @date ：Created in 2019/6/25 17:05
 * @description：TODO
 * @modified By：
 * @version: $
 */

public class AttemptLocking {
    private ReentrantLock lock = new ReentrantLock();
    // 如果获取失败，就可以做其他事情，而不是等待这个锁被释放
    public void untimed(){
        boolean captured = lock.tryLock();
        try{
            System.out.println("tryLock(): " + captured);
        }finally{
            if(captured)
                lock.unlock();
        }
    }
    public void timed(){
        boolean captured = false;
        try {
            //尝试获取，两秒后失败
            captured = lock.tryLock(2, TimeUnit.SECONDS);
        } catch(InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println("tryLock(2, TimeUnit.SECONDS): " +
                captured);
        } finally {
            if(captured)
                lock.unlock();
        }
    }
    public static void main(String[] args){
        final AttemptLocking al = new AttemptLocking();
        al.untimed();
        al.timed();
        new Thread() {
            { setDaemon(true); }
            public void run() {
                al.lock.lock();
                System.out.println("acquired");
            }
        }.start();
        Thread.yield();
//        al.untimed();
//        al.timed();
    }
}
