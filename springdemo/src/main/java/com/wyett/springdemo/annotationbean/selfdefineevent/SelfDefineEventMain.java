package com.wyett.springdemo.annotationbean.selfdefineevent;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/15 16:35
 * @description: TODO
 */

public class SelfDefineEventMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                new ClassPathXmlApplicationContext("SelfDefineEvent.xml");
        MyEventPublisher publisher =
                (MyEventPublisher) context.getBean("myEventPublisher");
        publisher.publish();
        publisher.publish();
    }
}
