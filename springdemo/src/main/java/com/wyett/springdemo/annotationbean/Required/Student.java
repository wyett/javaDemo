package com.wyett.springdemo.annotationbean.Required;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Required;


/**
 * @author : wyettLei
 * @date : Created in 2019/10/12 17:29
 * @description: TODO
 * @modified By:
 * @version: $
 */


@Getter
public class Student {
    private String name;
    private int age;

    @Required
    public void setName(String name) {
        this.name = name;
    }

    @Required
    public void setAge(int age) {
        this.age = age;
    }
}
