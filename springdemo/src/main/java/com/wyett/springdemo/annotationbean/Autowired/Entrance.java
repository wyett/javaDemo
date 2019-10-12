package com.wyett.springdemo.annotationbean.Autowired;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/12 19:14
 * @description: TODO
 */

public class Entrance {
    public Entrance() {
        System.out.println("Entrance constructor");
    }

    public void checkin() {
        System.out.println("checking in");
    }

    public void checkout() {
        System.out.println("checking out");
    }

    public void check() {
        checkin();
        checkout();
    }
}
