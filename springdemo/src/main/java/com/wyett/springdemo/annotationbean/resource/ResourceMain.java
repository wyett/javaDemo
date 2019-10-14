package com.wyett.springdemo.annotationbean.resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/14 16:59
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class ResourceMain {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("Resource.xml");
        Company obj = (Company) context.getBean("company");
        obj.checking();
    }
}
