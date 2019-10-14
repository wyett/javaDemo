package com.wyett.springdemo.annotationbean.javabean.dependbean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/14 18:28
 * @description: TODO
 */

public class DependBeanMain {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(CompanyConfig.class);
        Company obj = (Company) context.getBean(Company.class);
        obj.checking();
    }
}
