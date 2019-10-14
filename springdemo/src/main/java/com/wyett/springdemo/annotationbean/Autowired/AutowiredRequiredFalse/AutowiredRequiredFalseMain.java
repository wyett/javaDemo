package com.wyett.springdemo.annotationbean.Autowired.AutowiredRequiredFalse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/14 12:13
 * @description: TODO
 */

public class AutowiredRequiredFalseMain {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("AutowiredRequiredFalse.xml");
        Student obj = (Student) context.getBean("student");
        System.out.println(obj);

    }
}
