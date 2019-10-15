package com.wyett.springdemo.annotationbean.eventhandler;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/15 14:52
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class StartEventHandler implements ApplicationListener<ContextStartedEvent> {
    @Override
    public void onApplicationEvent(ContextStartedEvent start) {
        System.out.println("ContextStartedEvent recevied");
    }
}
