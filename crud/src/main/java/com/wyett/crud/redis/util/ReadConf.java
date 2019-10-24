package com.wyett.crud.redis.util;

import java.lang.annotation.*;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/24 19:11
 * @description: TODO
 */

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ReadConf {
    // get redis properties
    String value() default "";
}
