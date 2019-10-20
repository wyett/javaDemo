package com.wyett.thinkinjava.Annotation;

import java.util.Arrays;
import java.lang.annotation.Annotation;
/**
 * @author chelei
 * @date 2019/5/30 17:02
 */

@DocumentA
class F {}

@DocumentB
public class DocumentDemo3 extends F{
    public static void main(String[] args) {
        Class<?> clazz = DocumentDemo3.class;
        DocumentA documentA = clazz.getAnnotation(DocumentA.class);
        System.out.println("A: " + documentA );

        //get all document on this element
        Annotation[] an = clazz.getAnnotations();
        System.out.println("an:" + Arrays.toString(an));
        //get declared document on this element, with no inherited
        Annotation[] an2 = clazz.getDeclaredAnnotations();
        System.out.println("an2: " + Arrays.toString(an2));

        //check if DocumentA on this element
        boolean b = clazz.isAnnotationPresent(DocumentA.class);
        System.out.println("b: " + b);
    }
}
