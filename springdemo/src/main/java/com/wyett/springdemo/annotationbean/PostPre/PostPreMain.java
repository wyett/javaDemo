package com.wyett.springdemo.annotationbean.PostPre;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/14 16:31
 * @description: TODO
 */

public class PostPreMain {
    public static void main(String[] args) {
        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("PostPre.xml");
        Message obj = (Message) context.getBean("postpre");
        System.out.println(obj.getMessage());
        context.registerShutdownHook();
    }
}
