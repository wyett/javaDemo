package com.wyett.springdemo.di.dicollection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/12 15:23
 * @description: TODO
 */

public class DiCollectionMain {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("BeanCollection.xml");
        BeanCollection obj = (BeanCollection) context.getBean("beancollection");
        System.out.println(obj.getListCollection());
        System.out.println(obj.getMapCollection());
        System.out.println(obj.getSetCollection());
        System.out.println(obj.getPropsCollection());
    }
}
