package com.wyett.springdemo.ioccontainer.beanlifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/10 15:59
 * @description: TODO
 */

public class LifecycleBeanMain {
    public static void main(String[] args) {
        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("LifecycleBean.xml");
        SayHi obj = (SayHi) context.getBean("sayHi");
        obj.setMessage("how are you");
        obj.getMessage();
        context.registerShutdownHook();
    }
}
