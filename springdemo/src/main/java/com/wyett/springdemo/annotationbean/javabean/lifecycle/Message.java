package com.wyett.springdemo.annotationbean.javabean.lifecycle;

import lombok.Getter;
import lombok.Setter;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/14 19:28
 * @description: TODO
 * @modified By:
 * @version: $
 */

@Setter
@Getter
public class Message {
    private String message;

    public void init() {
        System.out.println("message init");
    }

    public void destory() {
        System.out.println("message destory");
    }
}
