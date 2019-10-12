package com.wyett.springdemo.helloworlddemo;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/9 15:24
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class SpringHelloWorld {
    private String message;
    public void setMessage(String message) {
        this.message = message;
    }

    public void getMessage() {
        System.out.println("Message: " + message);
    }
}
