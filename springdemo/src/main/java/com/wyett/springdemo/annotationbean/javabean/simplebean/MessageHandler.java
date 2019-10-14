package com.wyett.springdemo.annotationbean.javabean.simplebean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/14 18:04
 * @description: TODO
 */

@Configuration
public class MessageHandler {
    @Bean
    public Message message() {
        return new Message();
    }
}
