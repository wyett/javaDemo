package com.wyett.springdemo.di.dibycontructor;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/11 15:05
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class Entrance {
    public Entrance() {
        System.out.println("check in at Entrance");
    }

    public void checkin() {
        System.out.println("Checkin at morning");
    }

    public void checkout() {
        System.out.println("Checkout at evening");
    }

    public void check() {
        checkin();
        checkout();
    }
}
