package com.wyett.springdemo.annotationbean.resource;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/14 16:46
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class Entrance {
    private Entrance() {
        System.out.println("Entrance.constructor");
    }

    public void checkin() {
        System.out.println("Entrance.checkin()");
    }
    public void checkout() {
        System.out.println("Entrance.checkout()");
    }
}
