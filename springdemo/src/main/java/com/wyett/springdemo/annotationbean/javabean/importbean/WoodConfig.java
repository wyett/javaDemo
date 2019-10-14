package com.wyett.springdemo.annotationbean.javabean.importbean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/14 18:55
 * @description: TODO
 * @modified By:
 * @version: $
 */

@Configuration
public class WoodConfig {
    @Bean
    public Wood wood() {
        System.out.println("Wood.class");
        return new Wood();
    }
}
