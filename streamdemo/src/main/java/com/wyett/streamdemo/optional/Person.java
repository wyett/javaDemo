package com.wyett.streamdemo.optional;

import lombok.*;

import java.util.List;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/21 15:44
 * @description: TODO
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
public class Person {
    private String name;
    private Integer age;
    private GENDER gender;
    private String phoneNum;

}
