package com.wyett.confighandler;

import java.lang.annotation.*;

/**
 * @author : wyettLei
 * @date : Created in 2019/9/18 19:37
 * @description: TODO
 */

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ReadConf {
    String value() default  "";
}
