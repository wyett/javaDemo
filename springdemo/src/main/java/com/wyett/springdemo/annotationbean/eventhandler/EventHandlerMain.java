package com.wyett.springdemo.annotationbean.eventhandler;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/15 15:26
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class EventHandlerMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                new ClassPathXmlApplicationContext("EventHandler.xml");
        Message obj = (Message) context.getBean("message");
        context.start();
        obj.setMessage("Hello World");
        System.out.println(obj.getMessage());
        context.stop();
    }
}
