package datastructuresandalgorithms.list.practice;

import datastructuresandalgorithms.list.example.MyArrayList;

import java.util.NoSuchElementException;

/**
 * @author : wyettLei
 * @date : Created in 2019/8/6 11:16
 * @description: TODO
 */

public class Ex13_MyArrayList<E>
        extends MyArrayList<E> implements Iterable<E> {
    private int theSize;
    private E[] theItems;

    public java.util.Iterator<E> listIterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements java.util.ListIterator<E> {
        // current element
        public int current = 0;

        @Override
        public boolean hasNext() {
            return current < size();
        }

        @Override
        public boolean hasPrevious() {
            return current > 0;
        }

        @Override
        public E next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            return theItems[current++];
        }
        @Override
        public E previous() {
            if(!hasPrevious()) {
                throw new NoSuchElementException();
            }
            return theItems[--current];
        }

        @Override
        public void add(E x) {
            Ex13_MyArrayList.super.add(current++, x);
        }

        @Override
        public void remove() {
            Ex13_MyArrayList.super.remove(current--);
        }
        @Override
        public void set(E newVal) {
            Ex13_MyArrayList.super.set(current, newVal);
        }
        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException();
        }
        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException();
        }
    }
}
