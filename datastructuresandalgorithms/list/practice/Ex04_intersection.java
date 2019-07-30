package datastructuresandalgorithms.list.practice;

import datastructuresandalgorithms.list.example.MyArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author : wyettLei
 * @date : Created in 2019/7/30 21:05
 * @description: get intersection between two ArrayList
 */

public class Ex04_intersection<E> {
    public List<E> getIntersection(List<E> le1, List<E> le2) {
        List<E> leres = new ArrayList<>();
        Iterator<E> ie1 = le1.iterator();
        Iterator<E> ie2 = le2.iterator();

        while(ie1.hasNext()) {
            E tmp = ie1.next();
            while(ie2.hasNext()) {
                if(tmp == ie2.next()) {
                    leres.add(tmp);
                }
            }
            return leres;
        }
    }
    public static void main(String[] args) {
        Ex04_intersection<Integer> ex04 = new Ex04_intersection<>();
        List<Integer> li1 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        List<Integer> li2 = new ArrayList<>(Arrays.asList(1,3,6,7,9));
        System.out.println(ex04.getIntersection(li1, li2));
    }

}
