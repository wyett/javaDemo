package com.wyett.springdemo.ioccontainer.applicationcontext.singletonbeanscope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/9 18:29
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class SingletonBeanMain {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("SingletonBean.xml");
        HelloSingletonBean bean1 = (HelloSingletonBean) context.getBean("helloworld");
        bean1.setMessage("hello, A");
        bean1.getMessage();
        HelloSingletonBean bean2 = (HelloSingletonBean) context.getBean("helloworld");
//        bean2.setMessage("hello, B");
        bean2.getMessage();
    }
}
