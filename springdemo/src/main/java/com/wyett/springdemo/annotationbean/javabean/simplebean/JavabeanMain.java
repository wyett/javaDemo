package com.wyett.springdemo.annotationbean.javabean.simplebean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/14 18:11
 * @description: TODO
 */

public class JavabeanMain {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(MessageHandler.class);
        Message obj = (Message) context.getBean(Message.class);
        obj.setMessage("Hello World");
        System.out.println(obj.getMessage());
    }
}
