package com.wyett.streamdemo.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/20 17:11
 * @description: TODO
 */

public class StudentServer {
    private static List<Student> school = new ArrayList<>();

    static {
        school.add(new Student(1, "Jhon", 18, "USA"));
        school.add(new Student(2, "Tom", 20, "GER"));
        school.add(new Student(3, "Mike", 20, "IDN"));
        school.add(new Student(4, "Lily", 20, "UK"));
        school.add(new Student(5, "HanMeiMei", 20, "China"));
    }

    //some intermediate operation and one terminal operation at last
    //intermediate is lazy operation, it won't be excute until terminal
    // operation
    @Test
    public void test() {
        // fiter
        school.stream().filter(a -> true)
                .forEach(System.out::println);

        // no print hello, filter is intermediate operation
        school.stream().filter(a -> {
            System.out.println("hello");
            return true;
        });

        // peek 遍历流中所有元素, get all element
        school.stream().filter(a -> {
            System.out.println("hello");
            return true;
        }).peek(this::getCountry);

        System.out.println("=====================");
        // intermediate operation return stream type
        Stream<Student> tmpstream = school.stream().filter(a -> {
            System.out.println("hello");
            return true;
        });
        tmpstream.peek(this::getCountry).findFirst();


        System.out.println("=====================");
        // terminal count
        // and stream send the first object to the filter, peak;
        // then send the sencond object to the filter, peak, and so on
        school.stream().filter(a -> {
            System.out.println(a.getName());
            return a.getAge().equals(20);
        }).peek(this::getCountry).count();


        System.out.println("=====================");
        // map and forEach
        school.stream().map(a -> a.getAge()).forEach(System.out::println);


        System.out.println("=====================");
        // flatMap
        school.stream().map(a -> a.getName())
                .flatMap(s -> Arrays.stream(s.split("")))
                .forEach(System.out::println);


        System.out.println("=====================");
        //sort
        school.stream().filter(s -> s.getAge().equals(20))
                .map(s -> s.getNativeHome())
                .sorted()
                .forEach(System.out::println);


    }

    public void getCountry(Student a) {
        System.out.println(a.getNativeHome());
    }
}
