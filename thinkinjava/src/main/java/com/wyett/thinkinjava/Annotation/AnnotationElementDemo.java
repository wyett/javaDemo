package com.wyett.thinkinjava.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * @author chelei
 * @date 2019/5/30 14:25
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface  Reference {
    boolean next() default false;
}

public @interface AnnotationElementDemo{
    enum Status {FIXED, NORMAL};
    Status status() default Status.FIXED;
    boolean showSupport() default false;
    String name() default "";
    Class<?> testCase() default Void.class;
    Reference reference() default  @Reference(next=true);
    long[] value();
}
