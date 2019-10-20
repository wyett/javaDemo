package com.wyett.thinkinjava.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * @author chelei
 * @date 2019/5/30 15:36
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface IntegerValue{
    int value() default 0;
    String name() default "";
}

public class QuicklyWay {
    @IntegerValue(20)
    public int age;

    @IntegerValue(value = 10000, name = "MONEY")
    public int money;
}
