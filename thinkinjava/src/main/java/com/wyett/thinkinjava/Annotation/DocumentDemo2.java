package com.wyett.thinkinjava.Annotation;

import java.util.*;
import java.lang.annotation.*;
/**
 * @author chelei
 * @date 2019/5/30 16:33
 */
@Inherited
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface DocumentA2 {}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface DocumentB2{}

@DocumentA2
class A{}

class B extends A{}

@DocumentB2
class C{}

class D extends C{}

public class DocumentDemo2 {
    public static void main(String[] args){
        A instanceA = new B();
        System.out.println("已使用的@Inherited注解"
                + Arrays.toString(
                        instanceA.getClass().getAnnotations()));
        C instanceC = new D();
        System.out.println("没有使用@Interited注解"
                + Arrays.toString(
                        instanceC.getClass().getAnnotations()));
    }

}
