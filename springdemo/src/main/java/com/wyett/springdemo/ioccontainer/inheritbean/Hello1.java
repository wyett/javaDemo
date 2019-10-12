package com.wyett.springdemo.ioccontainer.inheritbean;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/10 19:00
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class Hello1 {
    private String message1;
    private String message2;

    public void setMessage1(String message1) {
        this.message1 = message1;
    }

    public void setMessage2(String message2) {
        this.message2 = message2;
    }

    public void getMessage1() {
        System.out.println("Message1: " + message1);
    }

    public void getMessage2() {
        System.out.println("Message2: " + message2);
    }
}
