package com.wyett.springdemo.annotationbean.javabean.importbean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/14 19:00
 * @description: TODO
 */

@Configuration
@Import(Wood.class)
public class SawConfig {
    @Bean
    public Saw saw() {
        System.out.println("Saw.class");
        return new Saw();
    }
}
