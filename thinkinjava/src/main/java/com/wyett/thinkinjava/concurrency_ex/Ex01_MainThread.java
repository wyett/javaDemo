package com.wyett.thinkinjava.concurrency_ex;

/**
 * @author ：chelei
 * @date ：Created in 2019/6/3 12:24
 * @description：TODO
 * @modified By：
 * @version: $
 */

public class Ex01_MainThread {
    public static void main(String[] args){
//        for(int i = 0; i < 5; i++) {
//            new Thread(new Ex01_Runnable("honey", 10))
//                    .start();
//        }
        new Thread(new Ex01_Runnable("honey", 10)).start();
        System.out.println("end of Ex01_MainThread");
    }
}
