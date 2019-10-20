package com.wyett.streamdemo.stream;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/20 17:04
 * @description: TODO */

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private String nativeHome;
}
