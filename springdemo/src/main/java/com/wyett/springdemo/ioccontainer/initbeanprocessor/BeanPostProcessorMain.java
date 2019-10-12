package com.wyett.springdemo.ioccontainer.initbeanprocessor;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/10 17:19
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class BeanPostProcessorMain {
    public static void main(String[] args) {
        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("BeanProcesser.xml");
        SayHello sayHelloBean = (SayHello) context.getBean("sayhello");
        sayHelloBean.setMessage("wyett");
        sayHelloBean.getMessage();
        context.registerShutdownHook();
    }
}
