package com.wyett.springdemo.annotationbean.javabean.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/14 19:28
 * @description: TODO
 */

@Configuration
public class MessageProducer {
    @Bean(initMethod = "init", destroyMethod = "destory")
    @Scope("prototype")
    public Message getMessage() {
        return new Message();
    }
}
