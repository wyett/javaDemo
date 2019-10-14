package com.wyett.springdemo.annotationbean.javabean.dependbean;

import lombok.Getter;
import lombok.Setter;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/14 18:18
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class Company {
    private Entrance entrance;
    public Company(Entrance entrance) {
        System.out.println("Company.constructor()");
        this.entrance = entrance;
    }
    public void checking() {
        entrance.checkin();
        entrance.checkout();
    }
}
