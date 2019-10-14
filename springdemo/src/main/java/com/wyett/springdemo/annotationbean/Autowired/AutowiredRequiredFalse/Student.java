package com.wyett.springdemo.annotationbean.Autowired.AutowiredRequiredFalse;

import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/14 12:09
 * @description: TODO
 */

@Getter
@ToString
public class Student {
    private String name;
    private Integer age;

    @Autowired
    public void setName(String name) {
        this.name = name;
    }

    @Autowired(required = false)
    public void setAge(int age) {
        this.age = age;
    }
}
