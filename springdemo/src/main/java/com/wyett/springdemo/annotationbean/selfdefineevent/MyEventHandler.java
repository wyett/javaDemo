package com.wyett.springdemo.annotationbean.selfdefineevent;

import org.springframework.context.ApplicationListener;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/15 16:27
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class MyEventHandler implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent event) {
        System.out.println(event.toString());
    }
}
