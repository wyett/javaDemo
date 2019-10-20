package com.wyett.thinkinjava.concurrency_ex.ovals;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : chelei
 * @date : Created in 2019/7/10 16:16
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class CommonQueue<T> {
    private Queue<T> queue = new LinkedList<T>();
    private int maxSize;
    public CommonQueue(int maxSize) { this.maxSize = maxSize; }
    public synchronized void put(T v) throws InterruptedException{
        while(queue.size() >= maxSize)
            wait();
        queue.offer(v);
        maxSize++;
        notifyAll();
    }
    public synchronized T get() throws InterruptedException {
        while(queue.isEmpty())
            wait();
        T Headv = queue.poll();
        maxSize--;
        notifyAll();
        return Headv;
    }
}
