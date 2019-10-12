package com.wyett.springdemo.di.dibycontructor;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/11 15:04
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class Company {
    private Entrance entrance;
    public Company(Entrance entrance) {
        System.out.println("Company contructor");
        this.entrance = entrance;
    }

    public void checking() {
        entrance.check();
    }
}
