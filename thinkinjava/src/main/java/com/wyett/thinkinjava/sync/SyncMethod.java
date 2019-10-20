package com.wyett.thinkinjava.sync;

/**
 * @author ：chelei
 * @date ：Created in 2019/6/10 20:45
 * @description：TODO
 * @modified By：
 * @version: $
 */

public class SyncMethod {
    public int i;
    public synchronized void syncTask() {
        i++;
    }
}
