package com.wyett.datastructuresandalgorithms.list.practice;

import com.wyett.datastructuresandalgorithms.list.example.MyArrayList;

import java.util.NoSuchElementException;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/6 16:58
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class Ex16_MyArrayList<E> extends MyArrayList<E> {
    private int theSize;
    private E[] theItems;

    public Ex16_MyArrayList(int theSize, E[] theItems) {
        super();
        this.theSize = theSize;
        this.theItems = theItems;
    }

    public java.util.Iterator<E> reverseIterator() {
        return new ArrayListReverseIterator();
    }

    private class ArrayListReverseIterator implements java.util.Iterator<E> {
        public int current = theSize;

        @Override
        public boolean hasNext() {
            return current > 0;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return theItems[current--];
        }

        @Override
        public void remove() {
            Ex16_MyArrayList.super.remove(--current);
        }
    }
}
