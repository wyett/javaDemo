package com.wyett.streamdemo.funcreference.staticfunc;

import org.junit.Test;

import java.util.*;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/23 11:45
 * @description: TODO
 */

public class DubbleSortTest {
    private static List<Integer[]> listToSorted = new ArrayList<>();
    private static int MAX_COUNT = 10;

    static {
        while(MAX_COUNT-- > 0) {
            listToSorted.add(createIntegerArr(10, 10));
        }
    }


    // create Array
    public static Integer[] createIntegerArr(int maxVal, int sizeOfArr) {
        Integer[] arr = new Integer[sizeOfArr];

        Random rand = new Random();
        for(int i = 0; i < sizeOfArr; i++) {
            arr[i] = rand.nextInt(maxVal);
        }

        return arr;
    }

    // sort
    @Test
    public void test() {
        listToSorted.stream().map(DubbleSort::dubbleSort)
                .map(s -> Arrays.toString(s))
                .forEach(System.out::println);
    }
}
