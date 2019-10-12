package com.wyett.springdemo.autowirebean.byconstructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/12 16:35
 * @description: TODO
 */

public class ByConstructorMain {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("ByConstructor.xml");
        Company obj = (Company) context.getBean("company");
        obj.checking();
        System.out.println(obj.getEntrance());
        System.out.println(obj.getName());
    }
}
