package com.wyett.springdemo.annotationbean.Autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/12 19:17
 * @description: TODO
 */

public class AutowiredMain {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("AutowiredConstructor.xml");
        Company obj = (Company) context.getBean("company");
        obj.checking();
    }
}
