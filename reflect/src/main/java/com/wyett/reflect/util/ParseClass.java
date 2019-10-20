package com.wyett.reflect.util;

import java.lang.reflect.Method;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/17 15:01
 * @description: TODO
 */

public class ParseClass<T> {
    private Class<T> clazz;
    public ParseClass(Class<T> clazz) {
        this.clazz = clazz;
    }

    public void getPackage() {
        System.out.println(clazz.getPackage().getName());
    }

//    public void getImport() {
//        StringBuilder importString = new StringBuilder();
//
//        String[] importArr = clazz.
//        for(String s: importArr) {
//            importString.append(s);
//        }
//
//        System.out.println(importArr);
//    }


    public void getAnnotationStr() {
        Method[] methods = clazz.getMethods();
        StringBuilder stringBuilder = new StringBuilder();
        for(Method method: methods) {
            stringBuilder.append(method.getAnnotations());
        }
        System.out.println(stringBuilder);
    }


    public void parse() {

        System.out.println("=======package path=======");
        System.out.println(clazz.getPackage().getName());
        System.out.println("==========================");

        System.out.println("getClass() or not");
        System.out.println("clazz: " + clazz);
        System.out.println("clazz.getClass(): " + clazz.getClass());
        System.out.println("==========================");

        System.out.println("class name");
        System.out.println(clazz.getCanonicalName());
        System.out.println(clazz.getName());
        System.out.println(clazz.getSimpleName());
        System.out.println("==========================");

        System.out.println("super class name");
        System.out.println(clazz.getSuperclass().getName());
        System.out.println("==========================");

        System.out.println("implement interface");
        System.out.println(clazz.getInterfaces());
        System.out.println("==========================");

        System.out.println("Fields");
        System.out.println(clazz.getFields().toString());
        System.out.println("==========================");

        System.out.println("private Fields");
        System.out.println(clazz.getDeclaredFields());
        System.out.println("==========================");

        System.out.println("field annotation");
        getAnnotationStr();
        System.out.println("==========================");


        System.out.println("constructor()");
        System.out.println(clazz.getConstructors().toString());
        System.out.println("==========================");

        System.out.println("method");
        System.out.println(clazz.getDeclaredMethods());
        System.out.println("==========================");
    }

//    public String printResourceCode() {
//
//    }
}
