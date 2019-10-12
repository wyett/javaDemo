package com.wyett.springdemo.autowirebean.ByNameAutoWire;

import com.wyett.springdemo.di.dibycontructor.Entrance;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/12 16:01
 * @description: TODO
 */

@Setter
@Getter
public class Company{
    private Entrance entrance;
    private String name;

    public void checking() {
        entrance.check();
    }
}
