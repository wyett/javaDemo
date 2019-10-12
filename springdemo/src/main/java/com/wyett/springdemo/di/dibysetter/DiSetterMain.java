package com.wyett.springdemo.di.dibysetter;

import com.wyett.springdemo.di.dibycontructor.Entrance;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/11 16:45
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class DiSetterMain {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("DibySetter.xml");
        Company obj = (Company) context.getBean("company");
        obj.checking();
    }
}
