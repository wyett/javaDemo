package com.wyett.thinkinjava.concurrency;

/**
 * @author ：chelei
 * @date ：Created in 2019/6/12 21:15
 * @description：TODO
 * @modified By：
 * @version: $
 */
class UnresponsiveUI {
    private volatile double d = 1;
    public UnresponsiveUI() throws Exception {
        while(d > 0)
            d = d + (Math.PI + Math.E)/d;
        System.in.read();
    }
}

public class ResponsiveUI extends Thread{
    private static volatile double d = 1;
    public ResponsiveUI() {
        setDaemon(true);
        start();
    }
    public void run() {
        while(true) {
            d = d + (Math.PI+ Math.E)/d;
        }
    }
    public static void main(String[] args) throws Exception {
//        new UnresponsiveUI();
        new ResponsiveUI();
        System.in.read();
        System.out.println(d);
    }
}
