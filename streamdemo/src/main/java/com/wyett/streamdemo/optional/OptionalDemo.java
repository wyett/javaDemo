package com.wyett.streamdemo.optional;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Stream;

import static com.wyett.streamdemo.optional.GENDER.FEMALE;
import static com.wyett.streamdemo.optional.GENDER.MALE;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/21 15:48
 * @description: TODO
 */

public class OptionalDemo {
    private static List<Person> pList = new ArrayList<>();

    static {
        pList.add(new Person("Tom", 22, MALE, "1234567"));
        pList.add(new Person("Jim", 23, null, "12346666"));
        pList.add(new Person("Kate", 24, FEMALE, null));
        pList.add(new Person("Jemes", 25, MALE, null));
        pList.add(new Person("Michille", 26, FEMALE, "12347777"));
    }

    // get()
    @Test
    public void testGet() {
        System.out.println("==========get()=========");
        // get every person
        /*for(Person p : pList) {
            Optional<Person> nowp = Optional.ofNullable(p);
            nowp.get();
        }*/
        pList.stream().forEach(s -> Optional.ofNullable(s).get());
    }

    //isPresent()
    @Test
    public void testIsPresent() {
        System.out.println("==========isPresent()=========");
        // check if every person is null
        pList.stream().map(s -> Optional.ofNullable(s).isPresent() ? true: false)
                .forEach(System.out::println);
        // check if element is null, then print person is null
//        pList.stream().flatMap(s -> Optional.ofNullable(s).isPresent() ? true: false)
        pList.stream().map(s -> s.toString())
                .forEach(System.out::println);
    }

    //ifPresent
    @Test
    public void testIfPresent() {
        pList.stream().forEach(s -> Optional.ofNullable(s)
                .ifPresent(a -> System.out.println(a.getName())));
    }

    // filter
    @Test
    public void testFilter() {
        pList.stream().forEach(
                s -> Optional.ofNullable(s)
                        .filter(u -> u.getGender() == MALE)
                        .ifPresent(u -> System.out.println(u)));
    }


    // map
    @Test
    public void testMap() {
        pList.stream().forEach(s -> Optional.ofNullable(s)
                                    .map(u -> u.getName()));
    }

    // flatMap
    @Test
    public void testFlatMap() {
        pList.stream().forEach(s -> Optional.ofNullable(s)
                            .flatMap(u -> Optional.ofNullable(u.getName())));
    }

    // orElse
    @Test
    public void testOrElse() {
        pList.stream().forEach(s -> Optional.ofNullable(s)
                            .map(u -> u.getPhoneNum()).orElse("unknow"));
    }

    //



}
