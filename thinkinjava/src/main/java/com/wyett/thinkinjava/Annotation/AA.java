package com.wyett.thinkinjava.Annotation;
import java.lang.annotation.*;
/**
 * @author ：wyettLei
 * @date ：Created in 2019/5/31 16:40
 * @description：${description}
 * @modified By：
 * @version: version
 */

@Target({ElementType.TYPE,ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Inherited //可以继承元注解
@Repeatable(FiltPaths.class)
@interface FilterPath {
    String value();
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited //可以继承元注解
@interface FiltPaths {
    FilterPath[] value();
}

@FilterPath("/web/list")
@FilterPath("/web/getList")
class CC {}

/*
@FilterPath("/web/update")
@FilterPath("/web/add")
@FilterPath("/web/delete")
*/
public class AA extends CC {
    public static void main(String[] args) {
        Class<?> clazz = AA.class;
        //通过getAnnotationsByType获取注解
        FilterPath[] annotationsByType =
                clazz.getAnnotationsByType(
                        FilterPath.class);
        FilterPath[] annotationsByType2 =
                clazz.getDeclaredAnnotationsByType(
                        FilterPath.class);
        if(annotationsByType != null) {
            for(FilterPath filter : annotationsByType) {
                System.out.println("1:"
                        + filter.value());
            }
        }
        System.out.println("--------------");
        if(annotationsByType2 != null) {
            for(FilterPath filter : annotationsByType2) {
                System.out.println("2:" + filter.value());
            }
        }
        System.out.println("使用getAnnotation的结果:"+
            clazz.getAnnotation(FilterPath.class));
    }
}
