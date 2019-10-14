package com.wyett.springdemo.annotationbean.qualifier;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/14 14:56
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class QualifierMain {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("Qualifier.xml");
        PrintStudent obj = (PrintStudent) context.getBean("printstudent");
        obj.printName();
        obj.printAge();
        Student obj2 = (Student) context.getBean("student2");
        System.out.println(obj2);
    }
}
