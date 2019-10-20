package com.wyett.thinkinjava.concurrency;

/**
 * @author ：chelei
 * @date ：Created in 2019/6/25 11:21
 * @description：TODO
 * @modified By：
 * @version: $
 */

public class SynchronizedEvenGenerator extends IntGenerator{
    private int currentEvenValue = 0;
    public synchronized int next() {
        ++currentEvenValue;
        Thread.yield();
        ++currentEvenValue;
        return currentEvenValue;
    }
    public static void main(String[] args){
        EvenChecker.test(new SynchronizedEvenGenerator());
    }
}
