package com.wyett.reflect.example;

import lombok.*;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/17 17:46
 * @description: TODO
 */

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ClassA {
    private String name;
    private Integer age;
}
