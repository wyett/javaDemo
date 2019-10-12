package com.wyett.springdemo.ioccontainer.initbeanprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/10 17:12
 * @description: TODO
 */

public class SayHelloBeanProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("modify bean before initialization " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("modify bean after initialization " + beanName);
        return bean;
    }
}
