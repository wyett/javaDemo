package com.wyett.datastructuresandalgorithms.list.example;

/**
 * @author : wyettLei
 * @date : Created in 2019/7/24 21:20
 * @description: TODO
 * @modified By:
 * @version: $
 */

public interface ListIterator<AnyType> extends Iterator<AnyType> {
    boolean hasPrevious();

    AnyType privious();

    /**
     * add element x
     * O(N), but for ArrayList, cost much
     * for LinkedList, cost O(1)
     *
     * @param x
     */
    void add(AnyType x);

    /**
     * change the last value
     *
     * @param newVal
     */
    void set(AnyType newVal);
}
