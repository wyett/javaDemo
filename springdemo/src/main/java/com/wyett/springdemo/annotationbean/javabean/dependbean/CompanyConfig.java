package com.wyett.springdemo.annotationbean.javabean.dependbean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/14 18:23
 * @description: TODO
 * @modified By:
 * @version: $
 */

@Configuration
public class CompanyConfig {
    @Bean
    public Company company() {
        return new Company(entrance());
    }

    @Bean
    public Entrance entrance() {
        return new Entrance();
    }
}
