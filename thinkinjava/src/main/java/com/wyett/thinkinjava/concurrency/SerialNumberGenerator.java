package com.wyett.thinkinjava.concurrency;

/**
 * @author ：chelei
 * @date ：Created in 2019/6/25 19:03
 * @description：TODO
 * @modified By：
 * @version: $
 */

public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;
    public static int nextSerialNumber() {
        // not thread-safe
        return serialNumber++;
    }
}
