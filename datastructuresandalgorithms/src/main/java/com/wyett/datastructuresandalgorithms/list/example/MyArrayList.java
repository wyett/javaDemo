package com.wyett.datastructuresandalgorithms.list.example;

import java.util.Iterator;

/**
 * @author : wyettLei
 * @date : Created in 2019/7/25 16:25
 * @description: TODO
 * @modified By:
 * @version: $
 */

public class MyArrayList<E> implements Iterable<E> {
    // default size of new MyArrayList
    private static final int DEFAULT_CAPACITY = 10;
    // real size of MyArrayList
    private int theSize;
    // array
    private E[] theItems;

    /**
     * initialize MyArrayList
     *
     * @param * @Param: null
     * @return
     */
    public MyArrayList() {
        doClear();
    }

    /**
     * @param * @Param: null
     * @return
     */
    public void clear() {
        doClear();
    }

    /**
     * set theSize to zero, and call
     * ensureCapacity() to get a large enough size
     *
     * @param * @Param: null
     * @return
     */
    public void doClear() {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    /**
     * get size of MyArrayList
     *
     * @param * @Param: null
     * @return int
     */
    public int size() {
        return theSize;
    }

    /**
     * description: TODO
     *
     * @param * @Param: null
     * @return boolean
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * modify length of MyArrayList
     *
     * @param * @Param: null
     * @return
     */
    private void trimToSize() {
        ensureCapacity(size());
    }

    /**
     * return theItems[idx]
     *
     * @param * int idx
     * @return
     */
    public E get(int idx) {
        if (idx < 0 || idx > size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return theItems[idx];
    }

    /**
     * set the idxth elem of arrayList theItems
     * to newVal, and return old value
     *
     * @param idx
     * @param newVal
     * @return E oldVal
     */
    public E set(int idx, E newVal) {
        if (idx < 0 || idx >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        E old = theItems[idx];
        theItems[idx] = newVal;
        return old;
    }

    /**
     * modify ArrayList to enough size
     *
     * @param newCapacity
     * @return
     */
    public void ensureCapacity(int newCapacity) {
        if (newCapacity < theSize) {
            return;
        }

        E[] old = theItems;
        theItems = (E[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            theItems[i] = old[i];
        }
    }

    public boolean contains(E elem) {
        E tmpElem = null;
        for (int i = 0; i < theSize; i++) {
            if (theItems[i] == elem) {
                tmpElem = elem;
                break;
            }
        }
        if (tmpElem != null) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * add new elem x at the end of ArrayList
     * if sucessed, return true
     *
     * @param x
     * @return boolean
     */
    public boolean add(E x) {
        add(size(), x);
        return true;
    }

    /**
     * add new elem x at idxth pos of ArrayList
     *
     * @param idx
     * @param x
     * @return
     */
    public void add(int idx, E x) {
        if (theItems.length == size()) {
            ensureCapacity(size() * 2 + 1);
        }
        for (int i = theSize; i > idx; i--) {
            theItems[i] = theItems[i - 1];
        }
        theItems[idx] = x;
        theSize++;
    }

    /**
     * @param items
     */
    public void addAll(Iterable<? extends E> items) {
        Iterator<? extends E> itemIterator = items.iterator();
        while (itemIterator.hasNext()) {
//            theItems[theSize++] = itemIterator.next();
            add(itemIterator.next());
        }
    }

    /**
     * remove idxth element and make
     * theItems[i] = theItems[i + 1], i = idx;
     *
     * @param idx
     * @return E value
     */
    public E remove(int idx) {
        E removeItem = theItems[idx];
        for (int i = idx; i < size() - 1; i++) {
            theItems[i] = theItems[i + 1];
        }
        theSize--;
        return removeItem;

    }

    @Override
    public java.util.Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements java.util.Iterator<E> {
        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < size();
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            return theItems[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--current);
        }
    }
}
