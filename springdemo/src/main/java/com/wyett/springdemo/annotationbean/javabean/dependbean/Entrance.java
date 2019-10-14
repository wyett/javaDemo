package com.wyett.springdemo.annotationbean.javabean.dependbean;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/14 18:19
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class Entrance {
    public Entrance() {
        System.out.println("Entrance.constructor()");
    }

    public void checkin() {
        System.out.println("Check in");
    }

    public void checkout() {
        System.out.println("check out");
    }
}
