package com.wyett.thinkinjava.concurrency_ex;

/**
 * @author ：chelei
 * @date ：Created in 2019/6/3 11:29
 * @description：TODO
 * @modified By：
 * @version: $
 */

public class Ex01_Runnable implements Runnable {
    protected static int cnt = 10;
    private static long counter = 0;
    private final long id = counter++;
    private String name;
    /*public Ex01_Runnable() {
        System.out.println("start of Ex01_Runnable");
    }*/
    public Ex01_Runnable(String name, int cnt) {
        System.out.println("start of " + id + " Ex01_Runnable");
        this.name = name;
        this.cnt = cnt;
    }
    public String callWho(int iTime) {
        return "call " + name + " " + iTime + " times" +
                (iTime == 0 ? " ": ", ");
    }
    public void run(){
        while(cnt-- > 0) {
            System.out.println(id + ": " + callWho(cnt));
            Thread.yield();
        }
        System.out.println("end of  " + id + " Ex01_Runnable");
    }
}
