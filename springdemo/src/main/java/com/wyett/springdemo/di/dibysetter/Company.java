package com.wyett.springdemo.di.dibysetter;

import com.wyett.springdemo.di.dibycontructor.Entrance;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/11 16:40
 * @description: TODO
 */

public class Company {
    private Entrance entrance;

    public void setEntrance(Entrance entrance) {
        System.out.println("Company.setEntrance");
        this.entrance = entrance;
    }

    public void getEntrance() {
        System.out.println("Entrance: " + entrance);
    }

    public void checking() {
        entrance.check();
    }
}
