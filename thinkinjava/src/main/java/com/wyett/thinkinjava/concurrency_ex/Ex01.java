package com.wyett.thinkinjava.concurrency_ex;

/**
 * @author ：chelei
 * @date ：Created in 2019/6/3 12:05
 * @description：TODO
 * @modified By：
 * @version: $
 */

public class Ex01 {
    public static void main(String[] args) {
        Ex01_Runnable ex01 =
                new Ex01_Runnable("honey", 10);
        ex01.run();
    }
}
