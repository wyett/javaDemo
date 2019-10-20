package com.wyett.thinkinjava.concurrency;

/**
 * @author ：chelei
 * @date ：Created in 2019/5/31 21:04
 * @description：TODO
 * @modified By：
 * @version: $
 */

public class MainThread {
    public static void main(String[] args) {
        LiftOff launch = new LiftOff();
        launch.run();
    }
}
