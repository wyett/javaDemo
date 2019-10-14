package com.wyett.springdemo.annotationbean.resource;

import javax.annotation.Resource;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/14 16:46
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class Company {
    private Entrance entrance;
    @Resource(name="entrance")
    public void setEntrance(Entrance entrance) {
        System.out.println("company.setEntrance()");
        this.entrance = entrance;
    }

    public Entrance getEntrance() {
        return entrance;
    }

    public void checking() {
        entrance.checkin();
        entrance.checkout();
    }
}
