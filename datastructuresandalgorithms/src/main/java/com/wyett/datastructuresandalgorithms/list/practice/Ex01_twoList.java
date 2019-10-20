package com.wyett.datastructuresandalgorithms.list.practice;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author : wyettLei
 * @date : Created in 2019/7/30 10:38
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class Ex01_twoList {
    public static ArrayList<Integer> printLots(
            ArrayList<Integer> l, ArrayList<Integer> p) {
        ArrayList<Integer> ai = new ArrayList<>();
        for (int i = 0; i < p.size(); i++) {
            if (p.get(i) < l.size()) {
                ai.add(l.get(p.get(i)));
            }
        }
        return ai;
    }

    public static void main(String[] args) {
        ArrayList<Integer> L = new ArrayList<>(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println(L.get(0));
        ArrayList<Integer> P = new ArrayList<>(Arrays.asList(0, 1, 2, 6, 9, 10));
        System.out.println(printLots(L, P));
    }
}
