package com.wyett.springdemo.di.dibycontructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/11 15:08
 * @description: TODO
 */

public class DiContructorMain {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("DiContructor.xml");
        Company obj = (Company) context.getBean("company");
        obj.checking();
    }
}
