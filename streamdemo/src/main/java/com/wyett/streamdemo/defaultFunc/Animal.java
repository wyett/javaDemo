package com.wyett.streamdemo.defaultFunc;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/23 10:43
 * @description: TODO
 */

public interface Animal {
    void run();
    default void eat() {
        System.out.println("most Animal eat meat");
    }
}
