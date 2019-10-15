package com.wyett.springdemo.annotationbean.selfdefineevent;

import org.springframework.context.ApplicationEvent;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/15 16:18
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class MyEvent extends ApplicationEvent {
    public MyEvent(Object event) {
        super(event);
    }

    public String toString() {
        return "MyEvent init";
    }
}
