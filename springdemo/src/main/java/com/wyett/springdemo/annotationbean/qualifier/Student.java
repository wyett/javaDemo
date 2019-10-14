package com.wyett.springdemo.annotationbean.qualifier;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/14 14:47
 * @description: TODO
 * @modified By:
 * @version: $
 */

@Setter
@Getter
@ToString
public class Student {
    private String name;
    private Integer age;
}
