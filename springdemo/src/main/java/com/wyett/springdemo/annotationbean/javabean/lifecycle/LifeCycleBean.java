package com.wyett.springdemo.annotationbean.javabean.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/14 19:35
 * @description: TODO
 */

public class LifeCycleBean {
    public static void main(String[] args) {
        AbstractApplicationContext context =
                new AnnotationConfigApplicationContext(MessageProducer.class);
        Message obj = (Message) context.getBean(Message.class);
        obj.setMessage("Hello World");
        System.out.println(obj.getMessage());
        context.registerShutdownHook();
    }
}
