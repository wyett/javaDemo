package com.wyett.springdemo.autowirebean.ByNameAutoWire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/12 16:05
 * @description: TODO
 */

public class ByNameMain {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("ByNameAutowire.xml");
        Company obj = (Company) context.getBean("company");
        obj.checking();
        System.out.println(obj.getEntrance());
        System.out.println(obj.getName());
    }
}
