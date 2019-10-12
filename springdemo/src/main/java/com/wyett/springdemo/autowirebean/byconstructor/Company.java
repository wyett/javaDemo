package com.wyett.springdemo.autowirebean.byconstructor;

import com.wyett.springdemo.di.dibycontructor.Entrance;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/12 16:29
 * @description: TODO
 */

@Getter
@AllArgsConstructor
public class Company {
    private Entrance entrance;
    private String name;

    public void checking() {
        entrance.check();
    }
}
