package com.wyett.springdemo.annotationbean.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/14 14:49
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class PrintStudent {
    @Autowired
    @Qualifier("student1")
    private Student student;

    public void printName() {
        System.out.println("Name: " + student.getName());
    }

    public void printAge() {
        System.out.println("Age: " + student.getAge());
    }
}
