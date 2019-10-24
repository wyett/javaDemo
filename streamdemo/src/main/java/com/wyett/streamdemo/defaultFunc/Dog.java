package com.wyett.streamdemo.defaultFunc;

import org.junit.Test;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/23 10:45
 * @description: default function can either be over write or not
 */

public class Dog implements Animal{
    @Override
    public void run() {
        System.out.println("Dog run 20 miles per hours");
    }

    public static void main(String[] args) {
        new Dog().run();
        new Dog().eat();
    }
}
