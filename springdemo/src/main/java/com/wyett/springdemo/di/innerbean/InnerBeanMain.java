package com.wyett.springdemo.di.innerbean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/12 10:58
 * @description: TODO
 */

public class InnerBeanMain {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("InnerBean.xml");
        Company obj = (Company) context.getBean("company");
        obj.checking();
    }
}
