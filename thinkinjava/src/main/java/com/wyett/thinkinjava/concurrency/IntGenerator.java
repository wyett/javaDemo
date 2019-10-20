package com.wyett.thinkinjava.concurrency;

/**
 * @author ：chelei
 * @date ：Created in 2019/6/17 16:25
 * @description：TODO
 * @modified By：
 * @version: $
 */

public abstract class IntGenerator {
    private volatile boolean canceled = false;
    public abstract int next();
    public void cancel() { canceled = true; }
    public boolean isCanceled() { return canceled; }
}
