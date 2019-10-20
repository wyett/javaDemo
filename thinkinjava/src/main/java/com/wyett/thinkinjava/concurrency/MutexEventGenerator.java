package com.wyett.thinkinjava.concurrency;

import java.util.concurrent.locks.*;
/**
 * @author ：chelei
 * @date ：Created in 2019/6/25 16:27
 * @description：TODO
 * @modified By：
 * @version: $
 */

public class MutexEventGenerator extends IntGenerator{
    private int currentEventValue = 0;
    private Lock lock = new ReentrantLock();
    public int next() {
        lock.lock();
        try{
            ++currentEventValue;
            Thread.yield();
            ++currentEventValue;
            return currentEventValue;
        } finally {
            lock.unlock();
        }
    }
    public static void main(String[] args){
        EvenChecker.test(new MutexEventGenerator());
    }

}
