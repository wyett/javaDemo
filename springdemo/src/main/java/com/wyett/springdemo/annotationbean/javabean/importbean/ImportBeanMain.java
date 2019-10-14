package com.wyett.springdemo.annotationbean.javabean.importbean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/14 19:17
 * @description: TODO
 */

public class ImportBeanMain {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(SawConfig.class);
        Wood wood = context.getBean(Wood.class);
        Saw saw = context.getBean(Saw.class);
    }
}
