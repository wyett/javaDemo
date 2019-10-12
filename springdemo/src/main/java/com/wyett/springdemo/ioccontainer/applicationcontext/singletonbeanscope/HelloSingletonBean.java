package com.wyett.springdemo.ioccontainer.applicationcontext.singletonbeanscope;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/9 18:27
 * @description: TODO
 */

public class HelloSingletonBean {
    private String message;
    public void setMessage(String message) {
        this.message = message;
    }

    public void getMessage() {
        System.out.println("Message: " + message);
    }
}
