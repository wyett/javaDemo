package com.wyett.springdemo.di.dicollection;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/12 14:42
 * @description: TODO
 */

@Setter
@Getter
public class BeanCollection {
    List listCollection;
    Set setCollection;
    Map mapCollection;
    Properties propsCollection;
}
