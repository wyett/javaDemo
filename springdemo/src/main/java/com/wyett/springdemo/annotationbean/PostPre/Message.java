package com.wyett.springdemo.annotationbean.PostPre;

import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/14 16:25
 * @description: TODO
 * @modified By:
 * @version: $
 */

@Setter
@Getter
public class Message {
    private String message;

    public Message() {
        System.out.println("Message.constructor");
    }

    @PostConstruct
    public void init() {
        System.out.println("test postconsturct");
    }

    @PreDestroy
    public void destory() {
        System.out.println("test predestory");
    }
}
