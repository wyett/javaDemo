package com.wyett.springdemo.ioccontainer.initbeanprocessor;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/10 17:06
 * @description: TODO
 */

public class SayHello {
    private String message;
    public void setMessage(String message) {
        this.message = message;
    }

    public void getMessage() {
        System.out.println("Message: Hello, " + message);
    }

    public void init() {
        System.out.println("init SayHello bean");
    }

    public void destory() {
        System.out.println("destory SayHello bean");
    }
}
