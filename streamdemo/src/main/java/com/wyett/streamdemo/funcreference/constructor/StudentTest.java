package com.wyett.streamdemo.funcreference.constructor;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/24 17:57
 * @description: TODO
 */

public class StudentTest {
    public static void main(String[] args) {
//        System.out.println(("Sam", 20) -> Student::new);
        Student student = JuniorStudent::new;

    }
}
