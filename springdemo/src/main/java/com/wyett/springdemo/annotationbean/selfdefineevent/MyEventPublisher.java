package com.wyett.springdemo.annotationbean.selfdefineevent;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/15 16:20
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class MyEventPublisher implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher appEventPublisher;
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher appEventPublisher) {
        this.appEventPublisher = appEventPublisher;
    }
    public void publish() {
        MyEvent myEvent = new MyEvent(this);
        appEventPublisher.publishEvent(myEvent);
    }
}
