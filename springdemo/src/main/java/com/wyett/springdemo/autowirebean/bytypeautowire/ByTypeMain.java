package com.wyett.springdemo.autowirebean.bytypeautowire;

import com.wyett.springdemo.autowirebean.ByNameAutoWire.Company;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/12 16:20
 * @description: TODO
 */

public class ByTypeMain {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("ByTypeAutowire.xml");
        Company obj = (Company) context.getBean("company");
        obj.checking();
    }
}
