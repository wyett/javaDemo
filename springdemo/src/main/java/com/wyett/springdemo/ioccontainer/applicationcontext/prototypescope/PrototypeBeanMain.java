package com.wyett.springdemo.ioccontainer.applicationcontext.prototypescope;

import com.wyett.springdemo.helloworlddemo.SpringHelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/9 18:37
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class PrototypeBeanMain {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("PrototypeBean.xml");
        SpringHelloWorld bean1 = (SpringHelloWorld) context.getBean("helloworld");
        bean1.setMessage("hello, A");
        bean1.getMessage();
        SpringHelloWorld bean2 = (SpringHelloWorld) context.getBean("helloworld");
        bean2.getMessage();
    }
}
