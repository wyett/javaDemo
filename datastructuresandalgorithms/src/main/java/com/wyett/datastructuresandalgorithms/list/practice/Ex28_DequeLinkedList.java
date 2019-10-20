package com.wyett.datastructuresandalgorithms.list.practice;

import java.util.LinkedList;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/8 20:22
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class Ex28_DequeLinkedList<E> {
    private LinkedList<E> le;

    public Ex28_DequeLinkedList() {
        le = new LinkedList<>();
    }

    public void push(E x) {
        le.addFirst(x);
    }

    public E pop() {
        return le.removeFirst();
    }

    public void inject(E x) {
        le.addLast(x);
    }

    public E eject() {
        return le.removeLast();
    }
}
