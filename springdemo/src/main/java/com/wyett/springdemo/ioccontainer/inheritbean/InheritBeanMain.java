package com.wyett.springdemo.ioccontainer.inheritbean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/10 19:12
 * @description: TODO
 */

public class InheritBeanMain {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("InheritBean.xml");
        Hello1 obj1 = (Hello1) context.getBean("hello1");
        obj1.getMessage1();
        obj1.getMessage2();

        Hello2 obj2 = (Hello2) context.getBean("hello2");
        obj2.getMessage1();
        obj2.getMessage2();
        obj2.getMessage3();
    }
}
