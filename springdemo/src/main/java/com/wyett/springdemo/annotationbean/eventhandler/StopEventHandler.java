package com.wyett.springdemo.annotationbean.eventhandler;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/15 14:56
 * @description: TODO
 */

public class StopEventHandler implements ApplicationListener<ContextStoppedEvent> {
    @Override
    public void onApplicationEvent(ContextStoppedEvent event) {
        System.out.println("ContextStopEvent received");
    }
}
