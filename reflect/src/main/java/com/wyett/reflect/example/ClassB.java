package com.wyett.reflect.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/17 17:46
 * @description: TODO
 */

@Setter
@Getter
@ToString
@NoArgsConstructor
public class ClassB extends ClassA {
    private String className;
    public ClassB(String className) {
        super();
        this.className = className;
    }
}
