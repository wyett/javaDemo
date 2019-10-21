package com.wyett.streamdemo.stream;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
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
        school.add(new Student(3, "Mike", 20, "USA"));
        school.add(new Student(4, "Lily", 25, "UK"));
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


        System.out.println("=====================");
        //find the oldest one
        school.stream().reduce((a, b) -> a.getAge() > b.getAge() ? a : b)
                .ifPresent(a -> System.out.println(a));

        System.out.println("=====================");
        //change stream into map
        HashMap<Integer, Student> map = school.stream().collect(HashMap::new,
                (m, a) -> m.put(a.getId(), a),
                (m1, m2) -> m1.putAll(m2));
        map.forEach((k, v) -> {
            System.out.println(k);
            System.out.println(v);
        });

        System.out.println("=====================");
        // get average age from the same country
        Collector<Student, ?, Map<String, Double>> groupCollector =
                Collectors.groupingBy((Student s) -> s.getNativeHome(),
                        Collectors.averagingInt((Student s) -> s.getAge()));
        school.stream().collect(groupCollector).forEach((k, v)
                -> System.out.println(k + ":" + v));




    }

    public void getCountry(Student a) {
        System.out.println(a.getNativeHome());
    }
}
