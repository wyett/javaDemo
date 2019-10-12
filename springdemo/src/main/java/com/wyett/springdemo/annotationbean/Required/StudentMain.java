package com.wyett.springdemo.annotationbean.Required;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/12 17:56
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class StudentMain {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("AnnotationBean.xml");
        Student obj = (Student) context.getBean("student");
        System.out.println(obj.getName());
        System.out.println(obj.getAge());
    }
}
