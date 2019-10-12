package com.wyett.springdemo.ioccontainer.beanlifecycle;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/10 11:00
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class SayHi {
    private String message;
    public void setMessage(String message) {
        this.message = message;
    }

    public void getMessage() {
        System.out.println("Message: Hi, " + message);
    }

    public void init() {
        System.out.println("initialize bean");
    }

    public void destory() {
        System.out.println("destory bean");
    }
}
