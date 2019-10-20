package com.wyett.thinkinjava.concurrency_ex;

/**
 * @author ：chelei
 * @date ：Created in 2019/6/3 18:01
 * @description：TODO
 * @modified By：
 * @version: $
 */

public class Ex02 {
    public static void main(String[] args) {
        for(int i = 0; i <= 5; i++)
            new Thread(new Ex02_Fibonacci(i)).start();
    }
}
