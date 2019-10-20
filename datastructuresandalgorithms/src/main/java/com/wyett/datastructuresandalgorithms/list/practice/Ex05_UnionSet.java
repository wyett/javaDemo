package com.wyett.datastructuresandalgorithms.list.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : wyettLei
 * @date : Created in 2019/7/31 11:06
 * @description: TODO
 */

public class Ex05_UnionSet<E> {
    /**
     * union two set
     *
     * @param le1 ArrayList has been sorted
     * @param le2 ArrayList has been sorted
     * @return ArrayList
     */
    public List<E> unionSet(List<E> le1, List<E> le2) {
        List<E> lres = new ArrayList<E>();

        for (E element1 : le1) {
            if (!lres.contains(element1)) {
                lres.add(element1);
            }
        }
        for (E element2 : le2) {
            if (!lres.contains(element2)) {
                lres.add(element2);
            }
        }
        return lres;
    }

    public static void main(String[] args) {
        Ex05_UnionSet<Integer> ex05 = new Ex05_UnionSet<>();
        List<Integer> li1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> li2 = new ArrayList<>(Arrays.asList(1, 3, 6, 7, 9));
        System.out.println(ex05.unionSet(li1, li2));
    }
}
