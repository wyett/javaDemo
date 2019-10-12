package com.wyett.springdemo.helloworlddemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.io.IOException;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/9 16:11
 * @description: TODO
 */

public class MainApp {
    public static void main(String[] args) throws IOException {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("Bean.xml");
        SpringHelloWorld helloWorld = (SpringHelloWorld)context.getBean("helloworld");
        helloWorld.getMessage();
    }
}
