package com.wyett.datastructuresandalgorithms.list.practice;

import java.util.LinkedList;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/8 21:30
 * @description: Self-adjusting list implements by LinkedList
 */

public class Ex30_SelfAdjustingListLinkedList<E> {
    private LinkedList<E> theList;

    private Ex30_SelfAdjustingListLinkedList(LinkedList<E> l) {
        this.theList = l;
    }

    public void find(E x) {
        if (theList.contains(x)) {
            theList.remove(x);
            theList.addFirst(x);
        }
    }

    public static void main(String[] args) {
        LinkedList<String> tmplinkedList = new LinkedList<>();
        Ex30_SelfAdjustingListLinkedList<String> tmpList =
                new Ex30_SelfAdjustingListLinkedList<>(tmplinkedList);
        tmplinkedList.add("a");
        tmplinkedList.add("b");
        tmplinkedList.add("c");
        tmpList.find("b");
        System.out.println(tmplinkedList);
    }
}
