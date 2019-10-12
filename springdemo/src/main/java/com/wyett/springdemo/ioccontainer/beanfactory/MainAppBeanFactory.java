package com.wyett.springdemo.ioccontainer.beanfactory;

import com.wyett.springdemo.helloworlddemo.SpringHelloWorld;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/9 17:38
 * @description: TODO
 */

public class MainAppBeanFactory {
    public static void main(String[] args) {
        XmlBeanFactory xmlBeanFactory =
                new XmlBeanFactory(new ClassPathResource("Bean.xml"));
        SpringHelloWorld helloWorld =
                (SpringHelloWorld) xmlBeanFactory.getBean("helloworld");
        helloWorld.getMessage();
    }
}
