package com.wyett.springdemo.annotationbean.Autowired;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/12 19:10
 * @description: TODO
 */

@Setter
@Getter
public class Company {
    private Entrance entrance;

    @Autowired
    public Company(Entrance entrance) {
        this.entrance = entrance;
    }

    public void checking() {
        entrance.check();
    }
}
